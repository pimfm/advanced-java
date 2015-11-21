package nl.HAN.ASD.APP.dataStructures;

/**
 * Created by Pim van Gurp, 9/16/2015.
 */
public class Tuple<T> {
    /**
     * Identifier of stored object.
     * Public, because it can be set and get
     */
    public String key;

    /**
     * Value of stored object.
     * Public, because it can be set and get
     */
    public T value;

    /**
     * A simple constructor for this simple class
     * @param key identifier of object
     * @param value value of object
     */
    public Tuple(String key, T value) {
        this.key = key;
        this.value = value;
    }

    /**
     * ToString method to print the Tuple very gracefully.
     * @return String representation of Tuple
     */
    @Override
    public String toString() {
        return "(\""+ key +"\", "+ value +")";
    }
}
