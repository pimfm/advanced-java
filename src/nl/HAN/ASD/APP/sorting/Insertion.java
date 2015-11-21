package nl.HAN.ASD.APP.sorting;

import nl.HAN.ASD.APP.generics.MemoryCell;

/**
 * Created by Pim van Gurp, 9/25/2015.
 */
public class Insertion<T extends Comparable<? super T>> implements ISorter<T> {
    /**
     * A simple sorting algorithm used to sort array without recursion
     * @return sorted array
     */
    @SuppressWarnings("unchecked")
    @Override
    public MemoryCell<T>[] sort(MemoryCell<T>[] toSort) {
        for(int i = 1; i < toSort.length; i++) {
            MemoryCell current = toSort[i];
            int j = i;
            while(j > 0 && toSort[j-1].compareTo(current) > 0) {
                toSort[j] = toSort[j-1];
                j--;
            }
            toSort[j] = current;
        }
        return toSort;
    }

    /**
     * Sort generic elements that are not stored in MemoryCells
     * @param toSort array with generic elements to sort
     * @return sorted array
     */
    @Override
    public T[] sort(T[] toSort) {
        for(int i = 1; i < toSort.length; i++) {
            T current = toSort[i];
            int j = i;
            while(j > 0 && toSort[j-1].compareTo(current) > 0) {
                toSort[j] = toSort[j-1];
                j--;
            }
            toSort[j] = current;
        }
        return toSort;
    }
}
