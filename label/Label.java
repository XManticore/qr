/*
 * Label.java
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
package label;
import java.util.EnumMap;
/** A representation of a label. Objects of this class are
 * typically constructed by readong a page layout from an XML file. The
 * accessors of the method can then be used by other programs that lay
 * stickers out onto sticker sheets.
 * 
 * Labels are created using the LabelBuilder class.
 * Labels themselves are immutable objects; values can only be set
 * to the LabelBuilder class..
 *
 * Values of lengths should be set in centimeters, with the exception of
 * text size, which should be set in pt. All dimensions returned by accessors
 * are returned in pixels, again except for text size (returned in pt).
 * Obviously this doesn't apply to unitless numbers.
 */
public class Label{
  /** Returns the value of the specified key. */
  public int get(LabelKey key){
    return fields.get(key);
  }
  /** This only gets called from LabelBuilder
   */
  protected Label(LabelBuilder b){
    fields = new EnumMap<LabelKey, Integer>(LabelKey.class);
    for(LabelKey key : LabelKey.values())
      fields.put(key, new Integer(LabelBuilder.get(key)));
  }
  @Override public String toString(){
     String s = "";
     s += "Label ";
     s += "Size (";
     s += fields.get(LabelKey.LABEL_WIDTH);
     s += "x";
     s += fields.get(LabelKey.LABEL_HEIGHT);
     s += ")px, QR code ";
     s += fields.get(LabelKey.QR_SIZE);
     s += "px high at {";
     s += fields.get(LabelKey.QR_X);
     s += ", ";
     s += fields.get(LabelKey.QR_Y);
     s += "), text label ";
     s += fields.get(LabelKey.TEXT_SIZE);
     s += "pt size at (";
     s += fields.get(LabelKey.TEXT_X);
     s += ", ";
     s += fields.get(LabelKey.TEXT_Y);
     s += ")";
     return s;
  }
  private final EnumMap<LabelKey, Integer> fields;
}
