package layout;
/** Used for building StickerSheets.  The static setter methods of this
 * class are used for setting the values of the StickerSheet. Once all
 * values have been set, the static build() method is called, which
 * returns an immutable StickerSheet object with those values.
 *
 * The getters and setters of this class all have the same name, but
 * the setters are invoked statically and take a parameter. 
 */
public class StickerSheetBuilder{
	/** The height of the page, in pixels
	 */
	 public int pageHeight(){
		return pageHeight;
	}
	/** The width of the page, in pixels
	 */
	 public int pageWidth(){
		return pageWidth;
	}
	/** The left margin of the page, in pixels
	 */
	 public int leftMargin(){
		return leftMargin;
	}
	/** The right margin of the page, in pixels
	 */
	 public int rightMargin(){
		return rightMargin;
	}
	/** The top margin of the page, in pixels
	 */
	 public int topMargin(){
		return topMargin;
	}
	/** The bottom margin of the page, in pixels
	 */
	 public int bottomMargin(){
		return bottomMargin;
	}
	/** The height of the sticker, in pixels
	 */
	public int stickerHeight(){
		return stickerHeight;
	}
	/** The width of the sticker, in pixels
	 */
	public int stickerWidth(){
		return stickerWidth;
	}
	/** The vertical gap between stickers, in pixels
	 */
	public int verticalGap(){
		return verticalGap;
	}
	/** The horizontal gap between stickers, in pixels
	 */
	public int horizontalGap(){
		return horizontalGap;
	}
	/** The number of rows in this page layout
	 */
	public int rows(){
		return rows;
	}
	/** The number of columns in this page layout
	 */
	public int columns(){
		return columns;
	}
	// SETTER METHODS AND HELPERS
	private static int toPixel(double mm){
		// assuming 300dpi
		//convert mm to inch
		double inch = mm * 0.0393700787;
		return (int)(inch * 300);
	}
	/** Sets the height of the page. Should be given in mm.
	 */
	 public static void pageHeight(double height){
		 pageHeight = toPixel(height);
	}
	/** The width of the page, in pixels
	 */
	 public static void pageWidth(double width){
		 pageWidth = toPixel(width);
	}
	/** The left margin of the page, in pixels
	 */
	 public static void leftMargin(double margin){
		 leftMargin = toPixel(margin);
	}
	/** The right margin of the page, in pixels
	 */
	 public static void rightMargin(double margin){
		 rightMargin = toPixel(margin);
	}
	/** The top margin of the page, in pixels
	 */
	 public static void topMargin(double margin){
		 topMargin = toPixel(margin);
	}
	/** The bottom margin of the page, in pixels
	 */
	 public static void bottomMargin(double margin){
		 bottomMargin = toPixel(margin);
	}
	/** The height of the sticker, in pixels
	 */
	public static void stickerHeight(double height){
		 stickerHeight = toPixel(height);
	}
	/** The width of the sticker, in pixels
	 */
	public static void stickerWidth(double width){
		 stickerWidth = toPixel(width);
	}
	/** The vertical gap between stickers, in pixels
	 */
	public static void verticalGap(double gap){
		 verticalGap = toPixel(gap);
	}
	/** The horizontal gap between stickers, in pixels
	 */
	public static void horizontalGap(double gap){
		 horizontalGap = toPixel(gap);
	}
	/** The number of rows in this page layout
	 */
	public static void rows(int row){
		rows = row;
	}
	/** The number of columns in this page layout
	 */
	public static void columns(int column){
		columns = column;
	}
	/** Returns a new sticker sheet with the values that have previously
	 * been set in this StickerSheetBuilder. If some of the values
	 * haven't been set yet, an exception is thrown.
	 * @throws UnsupportedOperationException if not all the values
	 * necessary to build a Sticker sheet have been set yet
	 */
	public static StickerSheet build(){
		if(rows == -1)
			throw new UnsupportedOperationException(
					"Value for " + rows + " has not been set!");
		if(columns == -1)
			throw new UnsupportedOperationException(
					"Value for " + columns + " has not been set!");
		if(horizontalGap == -1)
			throw new UnsupportedOperationException(
					"Value for " + horizontalGap + " has not been set!");
		if(verticalGap == -1)
			throw new UnsupportedOperationException(
					"Value for " + verticalGap + " has not been set!");
		if(stickerWidth == -1)
			throw new UnsupportedOperationException(
					"Value for " + stickerWidth + " has not been set!");
		if(stickerHeight == -1)
			throw new UnsupportedOperationException(
					"Value for " + stickerHeight + " has not been set!");
		if(bottomMargin == -1)
			throw new UnsupportedOperationException(
					"Value for " + bottomMargin + " has not been set!");
		if(topMargin == -1)
			throw new UnsupportedOperationException(
					"Value for " + topMargin + " has not been set!");
		if(leftMargin == -1)
			throw new UnsupportedOperationException(
					"Value for " + leftMargin + " has not been set!");
		if(rightMargin == -1)
			throw new UnsupportedOperationException(
					"Value for " + rightMargin + " has not been set!");
		if(pageHeight == -1)
			throw new UnsupportedOperationException(
					"Value for " + pageHeight + " has not been set!");
		if(pageWidth == -1)
			throw new UnsupportedOperationException(
					"Value for " + pageWidth + " has not been set!");
		return new StickerSheet(new StickerSheetBuilder());
	}
	private static int rows = -1;
	private static int columns = -1;
	private static int horizontalGap = -1;
	private static int verticalGap = -1;
	private static int stickerWidth = -1;
	private static int stickerHeight = -1;
	private static int bottomMargin = -1;
	private static int topMargin = -1;
	private static int leftMargin = -1;
	private static int rightMargin = -1;
	private static int pageHeight = -1;
	private static int pageWidth = -1;
}
