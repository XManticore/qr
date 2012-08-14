/*
 * StickerSheetBuilder.java
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
import java.util.EnumMap;
/** Used for building StickerSheets.  The static setter methods of this
 * class are used for setting the values of the StickerSheet. Once all
 * values have been set, the static build() method is called, which
 * returns an immutable StickerSheet object with those values.
 *
 * The getters and setters of this class all have the same name, but
 * the setters are invoked statically and take a parameter. 
 */
public class StickerSheetBuilder{
  private static int toPixel(double mm){
    // assuming 300dpi
    //convert mm to inch
    double inch = mm * 0.0393700787;
    return (int)(inch * 300);
  }
  /** Sets the value of the field `key' to `value'. This method may on;ly
   * be called once for each key.
   * @throws UnsupportedOperationException if the client attempts to set
   * the same key more than once.
   * 
   * Note that values should be set in millimeters for most fields. The
   * exceptions are ROWS and COLUMNS, which obviously are just set in
   * unitless numbers.
   */
  public static void set(LayoutKey key, double value){
    init();
    if(key == LayoutKey.ROWS
    || key == LayoutKey.COLUMNS)
      instance.fields.put(key, new Integer((int)value));
    else
      instance.fields.put(key, toPixel(value));
  }
  /** Returns the value of the key. The value is returned in pixels,
   * except for ROWS and COLUMNS which are returnes as unitless numbers.
   */
  protected int get(LayoutKey key){
    init();
    return instance.fields.get(key).intValue();
  }
  /** Builds and returns a new StickerSheet with the values that have
   * been set in this StickerSheetBuilder. If any of the values have not
   * been set, and exception is thrown.
   * @throws IllegalStateException if one or more of the values required
   * to build a new StickerSheet has not been set.
   */
  public static StickerSheet build(){
    for(LayoutKey key : instance.fields.keySet())
      if(instance.fields.get(key).intValue() == SENTINEL)
        throw new IllegalStateException(
            "A value has not been set for " + key);
    return new StickerSheet(instance);
  }
  private static void init(){
    if(instance == null)
      instance = new StickerSheetBuilder();
  }
  private StickerSheetBuilder(){
    fields = new EnumMap<LayoutKey, Integer>(LayoutKey.class);
    for(LayoutKey key : fields.keySet())
      fields.put(key, new Integer(-1));
  }
  private final static int SENTINEL = -1;
  private EnumMap<LayoutKey, Integer> fields;
  private static StickerSheetBuilder instance;
}
