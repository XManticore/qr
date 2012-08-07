package layout;
import javax.imageio.*;
import java.awt.*;
import java.util.*;
import java.awt.image.*;
import java.io.*;
class LabelPrint{
	/* The path to the folder of images.
	 */
	private static String root = "/tmp/images/";
	/* These coordinates represent the current position of the 'cursor'.
	 * Every time an image is drawn, the cursor is moved into position,
	 * ready for the next image.
	 */
	private static int x = 0;
	private static int y = 0;
	/* The current row and column of the paper. When a new page is started,
	 * these values are reset to zero.
	 */
	private static int row = 0;
	private static int column = 0;
	/* Current page number
	 */
	private static int page = 0;
	/* The actual class of this object will determine what layout the
	 * sheets will be printed in. Initialise this variable to some subtype
	 * of PageLayout to choose the layout.
	 */
	private static PageLayout layout;

	/* Opens a folder of images. Places them onto pages, and saves each
	 * page as pageX.png, where X is a variable-width integer.
	 */
	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("Please provide the directory where the QR codes "
					              +"are located as an argument");
			System.exit(1);
		}else if(args[0].startsWith("-h") || args[0].startsWith("--h")){
			System.out.println("LabelPrint");
			System.out.println("Usage: ./labelprint <image-dir>");
			System.exit(0);
		}else
			root = args[0];
		layout = new AveryAddressLabel();
		int pageHeight = layout.asPixels(layout.pageHeight());
		int pageWidth = layout.asPixels(layout.pageWidth());
		BufferedImage bi = new BufferedImage(pageWidth, pageHeight,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bi.createGraphics();
		g2d.setPaint(new Color(255, 255, 255));
		g2d.fill(new Rectangle(0, 0, 4000, 4000));
		BufferedImage img = null;
		initNewPage();
		File imageFolder = new File(root);
		File[] images = imageFolder.listFiles();
		Arrays.sort(images, new FileComparator());
		for(File file : images){
			try{
				img = ImageIO.read(file);
			}catch(Exception ex){
				ex.printStackTrace();
				System.exit(1);
			}
			// check if a new row needs to be started
			if(column == layout.columns()){
				column = 0;
				row++;
				x = layout.asPixels(layout.lmargin());
				y += layout.asPixels(layout.vGap());
				y += layout.asPixels(layout.stickerHeight());
			}
			// check if a new page needs to be started
			if(row == layout.rows()){
				save(bi, page);
				bi = new BufferedImage(pageWidth, pageHeight,
						BufferedImage.TYPE_INT_RGB);
				g2d = bi.createGraphics();
				g2d.setPaint(new Color(255, 255, 255));
				g2d.fill(new Rectangle(0, 0, 4000, 4000));
				initNewPage();
			}
			// Place image
			g2d = bi.createGraphics();
			g2d.drawImage(img, x, y, img.getWidth(), img.getHeight(), null);
			x += layout.asPixels(layout.stickerWidth());
			x += layout.asPixels(layout.hGap());
			column++;
		}
		save(bi, page);
	}
	/* Saves an image into a file called page[page].png
	 */
	private static void save(BufferedImage img, int page){
		try{
			ImageIO.write(img, "png", new File(root+"page"+page+".png"));
		}catch(Exception ex){
			ex.printStackTrace();
			System.exit(1);
		}
	}
	/* Changes the global coordinates to take account of margins.
	 */
	private static void initNewPage(){
		row = 0; column = 0;
		x = layout.asPixels(layout.lmargin());
		y = layout.asPixels(layout.tmargin());
		page++;
	}
	/* Prints a newline-delimited list of the array of objects passed as
	 * parameters
	 */
	private static void print(Object ... o){
		for(Object obj : o)
			System.out.println(obj);
	}
	public static class FileComparator implements Comparator<File>{
		@Override public int compare(File f1, File f2){
			String name1 = f1.getName();
			String name2 = f2.getName();
			name1 = name1.replaceAll("(\\d+)\\.png", "$1");
			name2 = name2.replaceAll("(\\d+)\\.png", "$1");
			if(Integer.parseInt(name1) > Integer.parseInt(name2)){
				return 1;
			}else if(Integer.parseInt(name1) < Integer.parseInt(name2)){
				return -1;
			}else
				throw new RuntimeException("Files have the same name!");
		}
	}
}
