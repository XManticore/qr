package layout;
/** A representation of a sticker sheet. Objects of this class are
 * typically constructed by readong a page layout from an XML file. The
 * accessors of the method can then be used by other programs that lay
 * stickers out onto sticker sheets.
 * 
 * StickerSheets are created using the StickerSheetBuilder class.
 * StickerSheets themselves are immutable objects; values can only be set
 * to the StickerSheetBuilder.
 *
 * The setter methods all return the object that they are being called
 * on, so that clients may chanin setters if necessary.
 *
 * Values of lengths should be set in centimeters, with the exception of
 * text size, which should be set in pt. All dimensions returned by accessors
 * are returned in pixels, again except for text size (returned in pt).
 * Obviously this doesn't apply to unitless numbers.
 */
public class StickerSheet{
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
	/** This only gets called from StickerSheetBuilder
	 */
	protected StickerSheet(StickerSheetBuilder b){
		rows = b.rows();
		columns = b.columns();
		horizontalGap = b.horizontalGap();
		verticalGap = b.verticalGap();
		stickerWidth = b.stickerWidth();
		stickerHeight = b.stickerHeight();
		bottomMargin = b.bottomMargin();
		topMargin = b.topMargin();
		leftMargin = b.leftMargin();
		rightMargin = b.rightMargin();
		pageHeight = b.pageHeight();
		pageWidth = b.pageWidth();
	}
	private int rows;
	private int columns;
	private int horizontalGap;
	private int verticalGap;
	private int stickerWidth;
	private int stickerHeight;
	private int bottomMargin;
	private int topMargin;
	private int leftMargin;
	private int rightMargin;
	private int pageHeight;
	private int pageWidth;
}
