package nl.HAN.ASD.APP.sorting;

import com.google.gag.annotation.remark.Magic;
import nl.HAN.ASD.APP.generics.MemoryCell;

/**
 * Created by Pim van Gurp, 9/25/2015.
 */
public class Merge<T extends Comparable<? super T>> implements ISorter<T> {
    /**
     * Sort an array of integers using the merge sort method.
     * This is the public function that uses the private function
     * @param toSort the array that needs to be sorted
     * @return the sorted array of integers
     */
    @SuppressWarnings("unchecked")
    @Override
    public MemoryCell<T>[] sort(MemoryCell<T>[] toSort) {
        if(toSort.length == 0) return toSort;
        MemoryCell<T>[] helper = new MemoryCell[toSort.length];
        sort(toSort, helper, 0, toSort.length - 1);
        return toSort;
    }

    /**
     * Sort generic elements that are not stored in MemoryCells
     * @param toSort array with generic elements to sort
     * @return sorted array
     */
    @SuppressWarnings("unchecked")
    @Override
    public T[] sort(T[] toSort) {
        if(toSort.length == 0) return toSort;
        T[] helper = (T[]) new Object[toSort.length];
        sort(toSort, helper, 0, toSort.length - 1);
        return toSort;
    }

    /**
     * Private merge sort function that sorts the array recursively.
     * @param toSort array of integers that needs to be sorted.
     * @param helper a helper array used to temporarily store the integers
     * @param from index in array from which the sorting takes place
     * @param to index in array to which the sorting takes place
     */
    private void sort(MemoryCell<T>[] toSort, MemoryCell<T>[] helper, int from, int to) {
        if(from >= to) return;
        int center = (from + to) / 2;
        sort(toSort, helper, from, center);
        sort(toSort, helper, center + 1, to);
        merge( toSort, helper, from, to );
    }

    /**
     * Private merge sort function that sorts the array recursively.
     * @param toSort array of integers that needs to be sorted.
     * @param helper a helper array used to temporarily store the integers
     * @param from index in array from which the sorting takes place
     * @param to index in array to which the sorting takes place
     */
    private void sort(T[] toSort, T[] helper, int from, int to) {
        if(from >= to) return;
        int center = (from + to) / 2;
        sort(toSort, helper, from, center);
        sort(toSort, helper, center + 1, to);
        merge( toSort, helper, from, to );
    }

    /**
     * Merge two sorted arrays together in a single one.
     * @param toSort the array of integers that needs to be sorted
     * @param helper helper class for temporarily storing integers
     * @param from index in array from which the sorting takes place
     * @param to index in array to which the sorting takes place
     */
    @Magic
    private void merge(MemoryCell<T>[] toSort, MemoryCell<T>[] helper, int from, int to) {
        int center = (from + to) / 2;
        System.arraycopy(toSort, from, helper, from, to + 1 - from);

        int i = from;
        int j = center + 1;
        int k = from;

        while(i <= center && j <= to) {
            toSort[k++] = (helper[i].compareTo(helper[j]) <= 0) ? helper[i++] : helper[j++];
        }
        while(i <= center) toSort[k++] = helper[i++];
    }

    /**
     * Merge two sorted arrays together in a single one.
     * @param toSort the array of integers that needs to be sorted
     * @param helper helper class for temporarily storing integers
     * @param from index in array from which the sorting takes place
     * @param to index in array to which the sorting takes place
     */
    @Magic
    private void merge(T[] toSort, T[] helper, int from, int to) {
        int center = (from + to) / 2;
        System.arraycopy(toSort, from, helper, from, to + 1 - from);

        int i = from;
        int j = center + 1;
        int k = from;

        while(i <= center && j <= to) {
            toSort[k++] = (helper[i].compareTo(helper[j]) <= 0) ? helper[i++] : helper[j++];
        }
        while(i <= center) toSort[k++] = helper[i++];
    }
}
