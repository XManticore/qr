/*
 * LabelBuilder.java
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
 */package label;
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
  private static int toPixel(double mm){
    double inch = mm * 0.0393700787;
    return (int)(inch * 300);
  }
  /** Returns the value associated with the label field.
   */
  protected static int get(LabelKey key){
    init();
    if(instance.fields.get(key) == null)
      throw new IllegalStateException(
        "The field for " + key + " has not been set");
    return instance.fields.get(key).intValue();
  }
  /** Sets the value of the field `key' to `value'. This method may only
   * be called once for each key.
   * @throws UnsupportedOperationException if the client attempts to set
   * the same key more than once.
   */
  public static void set(LabelKey key, double value){
    init();
    if(instance.fields.get(key) != null
    && instance.fields.get(key).intValue() != SENTINEL)
      throw new UnsupportedOperationException(
          "Attempted to set the value for " + key + " more than once");
    if(key == LabelKey.TEXT_SIZE)
      instance.fields.put(key, new Integer((int)value));
    else
      instance.fields.put(key, toPixel(value));
  }
  /** Builds and returns a new Label with the values that have been set
   * in this LabelBuilder. If any of the values have not been set, an
   * exception is thrown.
   * @throws IllegalStateException if one or more of the values required
   * to build a new StickerSheet has not been set.
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
