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
  STICKER_HEIGHT,
  /** The width of the sticker */
  STICKER_WIDTH,
  /** The vertical gap between stickers*/
  VERTICAL_GAP,
  /** The horixontal gap between stickers*/
  HORIZONTAL_GAP,
  /** The number of rows on the page*/
  ROWS,
  /** The number of columns on the page*/
  COLUMNS,
}
