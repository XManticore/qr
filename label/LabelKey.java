package label;
/** Specifies fields that are useful in laying out a label. This enum
 * describes the fields of the XML file that are useful for laying out a
 * label. The XML file is described by pageLayout.dtd 
 */
public enum LabelKey{
  /** The height of the label, in pixels */
  HEIGHT,
  /** The width of the label, in pixels */
  WIDTH,
  /** The size of the QR code, in pixels*/
  QR_SIZE,
  /** The horizontal postion of th qr code on the label*/
  QR_X,
  /** The vertical postion of th qr code on the label*/
  QR_Y,
  /** The size of the text, in pt*/
  TEXT_SIZE,
  /** The horizontal postion of th text on the label*/
  TEXT_X,
  /** The vertical postion of th text on the label*/
  TEXT_Y
}
