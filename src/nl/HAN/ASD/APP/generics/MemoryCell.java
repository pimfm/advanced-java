package nl.HAN.ASD.APP.generics;

/**
 * Created by Pim van Gurp, 9/8/2015.
 */
public class MemoryCell< T extends Comparable<? super T> > implements Comparable< MemoryCell<T> > {
    /**
     * Contains stored value in memory cell
     */
    private T value;

    /**
     * Get value in memory cell
     * @return stored value
     */
    public T read() {
        return value;
    }

    /**
     * Set stored value
     * @param value new stored value
     */
    public void write(T value) {
        this.value = value;
    }

    /**
     * Used to compare memory cells with each other
     * @param other object to compare current to
     * @return integer representation of which object is bigger
     *         -1   current object is smaller
     *         0    objects are equal
     *         1    current object is bigger
     */
    @SuppressWarnings("NullableProblems")
    @Override
    public int compareTo(MemoryCell<T> other) {
        return value.compareTo( other.read() );
    }

    /**
     * Return String representation of the memoryCell value
     * @return string containing memoryCell value
     */
    @Override
    public String toString() {
        return "MemoryCell("+ read() +")";
    }
}
