/*
 * LabelKey.java
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
package label;
/** Specifies fields that are useful in laying out a label. This enum
 * describes the fields of the XML file that are useful for laying out a
 * label. The XML file is described by pageLayout.dtd 
 */
public enum LabelKey{
  /** The height of the label*/
  LABEL_HEIGHT,
  /** The width of the label*/
  LABEL_WIDTH,
  /** The size of the QR code*/
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
