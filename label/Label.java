package layout;
/** A representation of a label. Objects of this class are
 * typically constructed by readong a page layout from an XML file. The
 * accessors of the method can then be used by other programs that lay
 * stickers out onto sticker sheets.
 * 
 * Labels are created using the LabelBuilder class.
 * Labels themselves are immutable objects; values can only be set
 * to the LabelBuilder class..
 *
 * The setter methods all return the object that they are being called
 * on, so that clients may chanin setters if necessary.
 *
 * Values of lengths should be set in centimeters, with the exception of
 * text size, which should be set in pt. All dimensions returned by accessors
 * are returned in pixels, again except for text size (returned in pt).
 * Obviously this doesn't apply to unitless numbers.
 */
public class Label{
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
	/** The size of the QR code, in pixels
	 */
	 public int qrSize(){
		return qrSize;
	}
	/** The horizontal position of the QR code on the label
	 */
	 public int qrX(){
		return qrX;
	}
	/** The vertical position of the QR code on the label
	 */
	 public int qrY(){
		return qrY;
	}
	/** The size of the text, in pt
	 */
	 public int textSize(){
		return textSize;
	}
	/** The horizontal position of the text on the label
	 */
	public int textX(){
		return textX;
	}
	/** The vertical position of the text on the label
	 */
	public int textY(){
		return textY;
	}
	/** This only gets called from LabelBuilder
	 */
	protected Label(LabelBuilder b){
		height = b.height();
		width = b.width();
		qrSize = b.qrSize();
		qrX = b.qrX();
		qrY = b.qrY();
		textSize = b.textSize();
		textX = b.textX();
		textY = b.textY();
	}
	private int height;
	private int width;
	private int qrSize;
	private int qrX;
	private int qrY;
	private int textSize;
	private int textX;
	private int textY;
}
