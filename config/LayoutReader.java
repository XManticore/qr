/*
 * LayoutReader.java
 * Copyright 2012 Kareem Khazem
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package config;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;
import java.util.*;
import label.*;
import layout.*;
public class LayoutReader{
  /** Builds an object that encapsulates layout information in an XML
   * file. Invoking this constructior will cause the XML file
   * `currentLayout.xml' to be parsed.
   */
  public LayoutReader(){
    SAXParser parser = null;
    try{
      parser = SAXParserFactory.newInstance().newSAXParser();
    }catch(ParserConfigurationException |
           SAXException ex){
      ex.printStackTrace();
      System.exit(1);
    }
    DefaultHandler handler = new DefaultHandler(){
      LayoutKey currentLayoutKey;
      LabelKey currentLabelKey;
      @Override public void startElement(String url, String localName,
                                         String qname, Attributes atts)
                                         throws SAXException{
        /* We're looking at an element, which may be relevant to building
         * a page layout or a label. We should check if the name of the
         * XML element matches a value of the LayoutKey or LabelKey
         * enums, and set the value of the current key accordingly.
         */
        for(LayoutKey key : LayoutKey.values())
          if(qname.toUpperCase().equals(key.toString())){
              currentLayoutKey = key;
          }
        for(LabelKey key : LabelKey.values())
          if(qname.toUpperCase().equals(key.toString())){
            currentLabelKey = key;
          }
      }
      @Override public void endElement(String uri, String localname,
                                       String qname) throws SAXException{
        currentLayoutKey = null;
        currentLabelKey = null;
      }
      @Override public void characters(char[] c, int start, int length)
                                      throws SAXException{
        if(currentLayoutKey != null)
          StickerSheetBuilder.set(currentLayoutKey, 
            Double.parseDouble(new String(c, start, length)));
        if(currentLabelKey != null)
          LabelBuilder.set(currentLabelKey, 
            Double.parseDouble(new String(c, start, length)));
        if(currentLabelKey == null && currentLayoutKey == null)
          throw new IllegalStateException(
            "Neither label nor layout are defined when receiving chars");
      }
    };
    try{
      parser.parse("config/currentLayout.xml", handler);
    }catch(IOException | IllegalArgumentException | SAXException ex){
      ex.printStackTrace();
      System.exit(1);
    }
    label = LabelBuilder.build();
    layout = StickerSheetBuilder.build();
  }
  /** Returns a Label that encapsulates label layout information.
   */
  public Label label(){
    return label;
  }
  /** Returns a layout that encapsulates page layout information.
   */
  public StickerSheet layout(){
    return layout;
  }
  private final Label label;
  private final StickerSheet layout;
  public static void main(String[] args){
    LayoutReader l = new LayoutReader();
    System.out.println(l.layout().get(LayoutKey.PAGE_HEIGHT));
    System.out.println(l.layout().get(LayoutKey.PAGE_WIDTH));
  }
}
