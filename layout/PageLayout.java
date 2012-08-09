/*
 * PageLayout.java
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
package layout;
/** Defines a layout for a sticker sheet.
 */
public abstract class PageLayout{
	/** The height of the page, in 1/100th millimeters.
	 */
	public int pageHeight(){
		return 29700;
	}
	/** The width of the page, in 1/100th millimeters.
	 */
	public int pageWidth(){
		return 21000;
	}
	/** The dots per inch count of the paper.
	 */
	public int dpi(){
		return 300;
	}
	/** The dots per mm count of the paper.
	 */
	public final int ppmm(){
		return (int)Math.round((toMM(dpi())));
	}
	/** Returns the millemeter argument in inches.
	 */
	public final double toInch(double mm){
		return mm * 0.0393700787;
	}
	/** Returns the inches argument in millimeters.
	 */
	public final double toMM(double inch){
		return inch / 0.0393700787;
	}
	/** Returns the argument, given in 100ths of millimeters, as pixels.
	 */
	public final int asPixels(int hundredMillis){
		//find size in inches
		double inchLength = toInch(hundredMillis / 100);
		// find number of pixels
		double pixels = inchLength * dpi();
		return (int)(Math.round(pixels));
	}
	/** The left margin of the paper, in 1/100th millimeters. This doesn't 
	 * include the hgap; the sticker starts immediately after the margin.
	 */
	public abstract int lmargin();
	/** The right margin of the paper, in 1/100th millimeters. This doesn't
	 * include the hgap; the sticker ends immediately after the margin.
	 */
	public abstract int rmargin();
	/** The top margin of the paper, in 1/100th millimeters. This doesn't 
	 * include the vgap; the sticker starts immediately after the margin.
	 */
	public abstract int tmargin();
	/** The bottom margin of the paper, in 1/100th millimeters. This doesn't 
	 * include the vgap; the sticker ends immediately after the margin.
	 */
	public abstract int bmargin();
	/** The height of the sticker, in 1/100th millimeters.
	 */
	public abstract int stickerHeight();
	/** The width of the sticker, in 1/100th millimeters.
	 */
	public abstract int stickerWidth();
	/** The horizontal gap between each sticker, in 1/100th millimeters.
	 */
	public abstract int hGap();
	/** The vertical gap between each sticker, in 1/100th millimeters.
	 */
	public abstract int vGap();
	/** How many rows of stickers fit on the page.
	 */
	public abstract int rows();
	/** How many columns of stickers fit on the page.
	 */
	public abstract int columns();
}
