package label;
import java.util.EnumMap;
/** A representation of a label. Objects of this class are
 * typically constructed by readong a page layout from an XML file. The
 * accessors of the method can then be used by other programs that lay
 * stickers out onto sticker sheets.
 * 
 * Labels are created using the LabelBuilder class.
 * Labels themselves are immutable objects; values can only be set
 * to the LabelBuilder class..
 *
 * Values of lengths should be set in centimeters, with the exception of
 * text size, which should be set in pt. All dimensions returned by accessors
 * are returned in pixels, again except for text size (returned in pt).
 * Obviously this doesn't apply to unitless numbers.
 */
public class Label{
  /** Returns the value of the specified key. */
  public int get(LabelKey key){
    return fields.get(key);
  }
  /** This only gets called from LabelBuilder
   */
  protected Label(LabelBuilder b){
    fields = new EnumMap<LabelKey, Integer>(LabelKey.class);
    for(LabelKey key : fields.keySet())
      fields.put(key, new Integer(LabelBuilder.get(key)));
  }
  private final EnumMap<LabelKey, Integer> fields;
}
