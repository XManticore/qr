package layout;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
class Main{
	/* The path to the folder of images.
	 */
	private static String root = "/homes/ec09414/qr/images/";
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
		layout = new AverySquareSticker();
		int pageHeight = layout.asPixels(layout.pageHeight());
		int pageWidth = layout.asPixels(layout.pageWidth());
		BufferedImage bi = new BufferedImage(pageWidth, pageHeight,
				BufferedImage.TYPE_INT_RGB);
		BufferedImage img = null;
		initNewPage();
		File imageFolder = new File(root);
		for(File file : imageFolder.listFiles()){
			print("Reading " + file.getName());
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
				Graphics2D g2d = bi.createGraphics();
				g2d.setPaint(new Color(255, 255, 255));
				g2d.fill(new Rectangle(0, 0, 4000, 4000));
				initNewPage();
			}
			print("Placing image at row " + row + ", column " + column +
					  " of page " + page);
			print("x: " + x + ", y: " + y);
			// Place image
			Graphics2D g2d = bi.createGraphics();
			g2d.drawImage(img, x, y, 512, 700, null);
			x += layout.asPixels(layout.stickerWidth());
			x += layout.asPixels(layout.hGap());
			column++;
		}
		save(bi, page);
	}
	/* Saves an image into a file called page[page].png
	 */
	private static void save(BufferedImage img, int page){
		print("Saving page " + page);
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
		x = layout.asPixels(layout.lmargin() / 10);
		y = layout.asPixels(layout.tmargin() / 10);
		page++;
	}
	/* Prints a newline-delimited list of the array of objects passed as
	 * parameters
	 */
	private static void print(Object ... o){
		for(Object obj : o)
			System.out.println(obj);
	}
}
