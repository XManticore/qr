package layout;
/** Used for building StickerSheets.  The static setter methods of this
 * class are used for setting the values of the StickerSheet. Once all
 * values have been set, the static build() method is called, which
 * returns an immutable StickerSheet object with those values.
 *
 * The getters and setters of this class all have the same name, but
 * the setters are invoked statically and take a parameter. 
 */
public class LabelBuilder{
	/** The height of the label, in pixels
	 */
	 public int height(){
		return height;
	}
	/** The width of the label, in pixels
	 */
	 public int width(){
		return width;
	}
	/** The size of the QR code in pixels
	 */
	 public int qrSize(){
		return qrSize;
	}
	/** The horizontal position of the qr code ont he label
	 */
	 public int qrX(){
		return qrX;
	}
	/** The vertical position of the qr code ont he label
	 */
	 public int qrY(){
		return qrY;
	}
	/** THe size of the text in pt
	 */
	 public int textSize(){
		return textSize;
	}
	/** The horizontal position of the text on the label
	 */
	public int textX(){
		return textX;
	}
	/** Thew vertical postion opf the texdt on the label
	 */
	public int textY(){
		return textY;
	}
	// SETTER METHODS AND HELPERS
	private static int toPixel(double mm){
		// assuming 300dpi
		//convert mm to inch
		double inch = mm * 0.0393700787;
		return (int)(inch * 300);
	}
	/** Sets the height of the Label. Should be given in mm.
	 */
	 public static void height(double height){
		 height = toPixel(height);
	}
	/** Sets The width of the page.  Should be given in mm.
	 */
	 public static void width(double width){
		 width = toPixel(width);
	}
	/** Sets the size of the QR code. Should be given in mm.
	 */
	 public static void qrSize(double size){
		 qrSize = toPixel(size);
	}
	/** Sets the horizontal p[ostion of th qr code ont he label
	 */
	 public static void qrX(double pos){
		 qrX = toPixel(pos);
	}
	/** Sets the vewrtical postion of the qr code on the label
	 */
	 public static void qrY(double pos){
		 qrY = toPixel(pos);
	}
	/** Sets the sixe of the text in pt
	 */
	 public static void textSize(double size){
		 textSize = toPixel(size);
	}
	/** Sets the horizontal position of the text on the label
	 */
	public static void textX(double textX){
		 textX = toPixel(textX);
	}
	/** Sets the vertical postion of the text on the label
	 */
	public static void textY(double textY){
		 textY = toPixel(textY);
	}
	/** Returns a new Label with the values that have previously
	 * been set in this LabelBuilder. If some of the values
	 * haven't been set yet, an exception is thrown.
	 * @throws UnsupportedOperationException if not all the values
	 * necessary to build a Sticker sheet have been set yet
	 */
	public static Label build(){
		if(height == -1)
			throw new UnsupportedOperationException(
					"Value for " + height + " has not been set!");
		if(width == -1)
			throw new UnsupportedOperationException(
					"Value for " + width + " has not been set!");
		if(qrSize == -1)
			throw new UnsupportedOperationException(
					"Value for " + qrSize + " has not been set!");
		if(qrX == -1)
			throw new UnsupportedOperationException(
					"Value for " + qrX + " has not been set!");
		if(qrY == -1)
			throw new UnsupportedOperationException(
					"Value for " + qrY + " has not been set!");
		if(textSize == -1)
			throw new UnsupportedOperationException(
					"Value for " + textSize + " has not been set!");
		if(textX == -1)
			throw new UnsupportedOperationException(
					"Value for " + textX + " has not been set!");
		if(textY == -1)
			throw new UnsupportedOperationException(
					"Value for " + textY + " has not been set!");
		throw new UnsupportedOperationException("not implemented");
	}
	private static int height = -1;
	private static int width = -1;
	private static int qrSize = -1;
	private static int qrX = -1;
	private static int qrY = -1;
	private static int textSize = -1;
	private static int textX = -1;
	private static int textY = -1;
}
