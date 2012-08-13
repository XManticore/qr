package label;
import java.util.EnumMap;
/** Used for building StickerSheets.  The static setter methods of this
 * class are used for setting the values of the StickerSheet. Once all
 * values have been set, the static build() method is called, which
 * returns an immutable StickerSheet object with those values.
 *
 * The getters and setters of this class all have the same name, but
 * the setters are invoked statically and take a parameter. 
 */
public class LabelBuilder{
  /** Returns the value associated with the label field.
   */
  protected static int get(LabelKey key){
    init();
    return instance.fields.get(key).intValue();
  }
  /** Sets the value of the field `key' to `value'. This method may only
   * be called once for each key.
   * @throws UnsupportedOperationException if the client attempts to set
   * the same key more than once.
   */
  public static void set(LabelKey key, int value){
    init();
    if(instance.fields.get(key).intValue() != SENTINEL)
      throw new UnsupportedOperationException(
          "Attempted to set the value for " + key + " more than once");
    instance.fields.put(key, value);
  }
  /** Builds and returns a new Label with the values that have been set
   * in this LabelBuilder. If any of the values have not been set, an
   * exception is thrown.
   */
  public static Label build(){
    for(LabelKey key : instance.fields.keySet())
      if(instance.fields.get(key).intValue() == SENTINEL)
        throw new IllegalStateException(
            "A value has not been set for " + key);
    return new Label(instance);
  }
  /** Sets up the map of fields. This should be called when any public
   * method is called on this class.
   */
  private LabelBuilder(){
    fields = new EnumMap<LabelKey, Integer>(LabelKey.class);
    for(LabelKey label : fields.keySet()){
      fields.put(label, new Integer(SENTINEL));
    }
  }
  private static void init(){
    if(instance == null)
      instance = new LabelBuilder();
  }
  /** Indicates that a field hasn't yet been set */
  private final static int SENTINEL = -1;
  private EnumMap<LabelKey, Integer> fields;
  private static LabelBuilder instance;
}
