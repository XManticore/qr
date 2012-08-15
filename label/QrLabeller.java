/*
 * QrLabeller.java
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
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import config.LayoutReader;
class QrLabeller{
  private static int HEIGHT;
  private static int WIDTH;
  private static int QR_SIZE;
  private static int TEXT_SIZE;
  private static int QR_X;
  private static int QR_Y;
  private static int TEXT_X;
  private static int TEXT_Y;
  public static void main(String[] args){
    if(args.length != 1){
      usage();
      System.exit(1);
    }else if(args[0].startsWith("-h") || args[0].startsWith("--help")){
      usage();
      System.exit(0);
    }else{
      GUI g = new GUI(args[0]);
    }
  }
  private static void usage(){
    System.out.println("QrLabeller");
    System.out.println("Usage: ./qrlabeller <image-dir> <layout-file>");
    System.out.println("<image-dir>   is where the QR codes are located.");
    System.out.println("              It should only contain QR codes.");
    System.out.println("<layout-file> is an XML file specifying the");
    System.out.println("              layout of labels.");
  }
  static class GUI{
    BufferedImage bi;
    MyPanel p;
    public GUI(String dir){
      super();
      String root = dir;
      readConfig();
      File imgFolder = new File(root);
      File[] files = imgFolder.listFiles();
      int counter = 0;
      for(File image : files){
        String newFileName; 
        System.out.println("Processing file '" + image.getName() + "' "
            + counter++);
        newFileName = image.getName().replaceAll("(\\d+)\\.png", "$1");
        try{
          bi = ImageIO.read(image);
        }
        catch(Exception ex){
          ex.printStackTrace();
          System.exit(1);
        }
        p = new MyPanel(bi, newFileName);
        BufferedImage newImg = p.getNewImage();
        try{
          ImageIO.write(newImg, "png", new File(root+newFileName+".png"));
        }catch(Exception ex){
          ex.printStackTrace();
          System.exit(1);
        }
      }
    }
    private void readConfig(){
      LayoutReader layout = new LayoutReader();
      Label label = layout.label();
      HEIGHT = label.get(LabelKey.LABEL_HEIGHT);
      WIDTH = label.get(LabelKey.LABEL_WIDTH);
      QR_SIZE = label.get(LabelKey.QR_SIZE);
      TEXT_SIZE = label.get(LabelKey.TEXT_SIZE);
      QR_X = label.get(LabelKey.QR_X);
      QR_Y = label.get(LabelKey.QR_Y);
      TEXT_X = label.get(LabelKey.TEXT_X);
      TEXT_Y = label.get(LabelKey.TEXT_Y);
    }
    static class MyPanel{
      BufferedImage img;
      public MyPanel(final BufferedImage i, String label){
        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        final Graphics2D g2d = img.createGraphics();
        g2d.setPaint(new Color(255,255,255));
        g2d.fill(new Rectangle(0, 0, WIDTH, HEIGHT));
        g2d.drawImage(i, QR_X, QR_Y, QR_SIZE, QR_SIZE, null);
        g2d.setPaint(new Color(0,0,0));
        g2d.setFont(new Font(Font.SANS_SERIF, 0, TEXT_SIZE));
        g2d.drawString(label, TEXT_X, TEXT_Y);
        g2d.dispose();
      }
      public BufferedImage getNewImage(){ return img; }
    }
  }
}
