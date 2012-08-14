/*
 * LayoutKey.java
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
/** Specifies the fields that are useful in laying out a page full of
 * stickers. This enum describes the fields of the XML file (specified by
 * pageLayout.dtd) that are useful for laying out a sheeet of stickers.
 */
public enum LayoutKey{
  /** The height of the page */
  PAGE_HEIGHT,
  /** The width of the page */
  PAGE_WIDTH,
  /** The left margin of the page */
  LEFT_MARGIN,
  /** The right margin of the page */
  RIGHT_MARGIN,
  /** The top margin of the page */
  TOP_MARGIN,
  /** The bottom margin of the page */
  BOTTOM_MARGIN,
  /** The height of the sticker */
  LABEL_HEIGHT,
  /** The width of the sticker */
  LABEL_WIDTH,
  /** The vertical gap between stickers*/
  VERTICAL_GAP,
  /** The horixontal gap between stickers*/
  HORIZONTAL_GAP,
  /** The number of rows on the page*/
  ROWS,
  /** The number of columns on the page*/
  COLUMNS,
}
