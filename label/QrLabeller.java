import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
class QrLabeller{
	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("Please provide the directory where the QR codes "
					              +"are located as an argument");
			System.exit(1);
		}else if(args[0].startsWith("-h") || args[0].startsWith("--help")){
			System.out.println("QrLabeller");
			System.out.println("Usage: ./qrlabeller <image-dir>");
			System.exit(0);
		}else{
			GUI g = new GUI(args[0]);
		}
	}
	static class GUI{
		BufferedImage bi;
		MyPanel p;
		public GUI(String dir){
			super();
			String root = dir;
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
		static class MyPanel{
			BufferedImage img;
			public MyPanel(final BufferedImage i, String label){
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
			public BufferedImage getNewImage(){ return img; }
		}
	}
}
