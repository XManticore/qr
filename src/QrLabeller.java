import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
class QrLabeller{
	public static void main(String[] args){
		GUI g = new GUI();
	}
	static class GUI extends JFrame{
		BufferedImage bi;
		MyPanel p;
		public GUI(){
			super();
			String root = "/homes/ec09414/qr/src/images/";
			File imgFolder = new File(root);
			File[] files = imgFolder.listFiles();
			int counter = 0;
			for(File image : files){
				String newFileName; 
				System.out.println("Processing file '" + image.getName() + "' " + counter++);
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
		static class MyPanel extends JPanel{
			BufferedImage img;
			public MyPanel(final BufferedImage i, String label){
				super();
				img = new BufferedImage(512, 700, BufferedImage.TYPE_INT_RGB);
				final Graphics2D g2d = img.createGraphics();
				g2d.setComposite(AlphaComposite.Src);
				g2d.setPaint(new Color(255,255,255));
				g2d.drawImage(i, 0, 0, 512, 512, null);
				g2d.fill(new Rectangle(0, 512, 512, 200));
				g2d.setPaint(new Color(0,0,0));
				g2d.setFont(new Font(Font.SANS_SERIF, 0, 150));
				g2d.drawString(label, 80, 600);
				g2d.dispose();
			}
			@Override public Dimension getPreferredSize(){
				if(img == null)
					return new Dimension(200, 200);
				else
					return new Dimension(img.getWidth(null), img.getHeight(null)+200);
			}
			@Override public void paint(Graphics g){
				super.paint(g);
				g.drawImage(img, 0, 0, null);
			}
			public BufferedImage getNewImage(){ return img; }
		}
	}
}
