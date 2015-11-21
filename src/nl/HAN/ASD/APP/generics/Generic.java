package nl.HAN.ASD.APP.generics;

/**
 * Created by Pim van Gurp, 9/8/2015.
 */
public class Generic<T extends Comparable<? super T>> {

    /**
     * A generic method that receives an array of any
     * type capable of compareTo and returns the smallest element
     * @param array array to compare
     * @return smallest element in array using compareTo
     */
    public T min(T[] array) {
        T minimum = array[0];
        for(T element : array) {
            if(minimum.compareTo(element) > 0) minimum = element;
        }
        return minimum;
    }

    /**
     * Compare two elements and return the
     * smallest element
     * @param e1 first element to compare
     * @param e2 second element to compare
     * @return the smallest element
     */
    public T min(T e1, T e2) {
        return (e1.compareTo(e2) < 0) ? e1 : e2;
    }

    /**
     * A generic method that receives an array of any
     * type capable of compareTo and returns the largest element
     * @param array array to compare
     * @return largest element in array using compareTo
     */
    public T max(T[] array) {
        T maximum = array[0];
        for(T element : array) {
            if(maximum.compareTo(element) < 0) maximum = element;
        }
        return maximum;
    }

    public T max(T e1, T e2) {
        return (e1.compareTo(e2) > 0) ? e1 : e2;
    }
}
