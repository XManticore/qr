package layout;
import java.util.EnumMap;
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
  /** Returns the value of the indicated key. The value is returned in
   * pixels, except for unitless values such as rowa and colums.
   */
  public int get(LayoutKey key){
    return fields.get(key);
  }
  /** This only gets called from StickerSheetBuilder
   */
  protected StickerSheet(StickerSheetBuilder b){
    fields = new EnumMap<LayoutKey, Integer>(LayoutKey.class);
    for(LayoutKey key : LayoutKey.values()){
      fields.put(key, new Integer(b.get(key)));
    }
  }
  private final EnumMap<LayoutKey, Integer> fields;
}
