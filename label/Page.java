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
	private StickerSheet(StickerSheetBuilder b){
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
	/** Used for building StickerSheets.  The static setter methods of this
	 * class are used for setting the values of the StickerSheet. Once all
	 * values have been set, the static build() method is called, which
	 * returns an immutable StickerSheet object with those values.
	 *
	 * The getters and setters of this class all have the same name, but
	 * the setters are invoked statically and take a parameter. The setters
	 * also return the object that they are invoked on (this), so that
	 * calls to setters can be chained if necessary.
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
		private static int toPixel(float mm){
			// assuming 300dpi
			//convert mm to inch
			float inch = mm * 0.0393700787;
			return (int)(inch * 300);
		}
		/** Sets the height of the page. Should be given in mm.
		 */
		 public static StickerSheetBuilder pageHeight(float height){
			 pageHeight = toPixel(height);
			 return this;
		}
		/** The width of the page, in pixels
		 */
		 public static StickerSheetBuilder pageWidth(float width){
			 pageWidth = toPixel(height);
			 return this;
		}
		/** The left margin of the page, in pixels
		 */
		 public static StickerSheetBuilder leftMargin(float margin){
			 leftMargin = toPixel(margin);
			 return this;
		}
		/** The right margin of the page, in pixels
		 */
		 public static StickerSheetBuilder rightMargin(float margin){
			 rightMargin = toPixel(margin);
			 return this;
		}
		/** The top margin of the page, in pixels
		 */
		 public static StickerSheetBuilder topMargin(float margin){
			 topMargin = toPixel(margin);
			 return this;
		}
		/** The bottom margin of the page, in pixels
		 */
		 public static StickerSheetBuilder bottomMargin(float margin){
			 bottomMargin = toPixel(margin);
			 return this;
		}
		/** The height of the sticker, in pixels
		 */
		public static StickerSheetBuilder stickerHeight(float height){
			 stickerHeight = toPixel(height);
			 return this;
		}
		/** The width of the sticker, in pixels
		 */
		public static StickerSheetBuilder stickerWidth(float width){
			 stickerWidth = toPixel(width);
			 return this;
		}
		/** The vertical gap between stickers, in pixels
		 */
		public static StickerSheetBuilder verticalGap(float gap){
			 verticalGap = toPixel(gap);
			 return this;
		}
		/** The horizontal gap between stickers, in pixels
		 */
		public static StickerSheetBuilder horizontalGap(float gap){
			 horizontalGap = toPixel(gap);
			 return this;
		}
		/** The number of rows in this page layout
		 */
		public static StickerSheetBuilder rows(int row){
			rows = row;
		  return this;
		}
		/** The number of columns in this page layout
		 */
		public static StickerSheetBuilder columns(int column){
			columns = column;
		  return this;
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
}
