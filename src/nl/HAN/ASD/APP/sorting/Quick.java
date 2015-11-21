package nl.HAN.ASD.APP.sorting;

import com.google.gag.annotation.remark.Magic;
import nl.HAN.ASD.APP.generics.MemoryCell;

/**
 * Created by Pim van Gurp, 9/25/2015.
 */
public class Quick<T extends Comparable<? super T>> implements ISorter<T> {
    /**
     * Sorting algorithm quick sort.
     * Select pivot and sort everything bigger and
     * smaller than the pivot
     * @param toSort array to sort
     * @return sorted array
     */
    @Override
    public MemoryCell<T>[] sort(MemoryCell<T>[] toSort) {
        if(toSort.length == 0) return toSort;
        sort(toSort, 0, toSort.length - 1);
        return toSort;
    }

    /**
     * Sorting algorithm quick sort.
     * Select pivot and sort everything bigger and
     * smaller than the pivot
     * @param toSort array to sort
     * @return sorted array
     */
    @Override
    public T[] sort(T[] toSort) {
        if(toSort.length == 0) return toSort;
        sort(toSort, 0, toSort.length - 1);
        return toSort;
    }

    /**
     * Internal call used by public sort function
     * @param toSort array to sort
     * @param from index to start sorting
     * @param to index to stop sorting
     * credits to: http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
     */
    @Magic
    private void sort(MemoryCell<T>[] toSort, int from, int to){
        MemoryCell<T> pivot = toSort[ (from + to) / 2 ];
        int i = from, j = to;

        while(i <= j) {
            while(toSort[i].compareTo(pivot) < 0) i++;
            while(toSort[j].compareTo(pivot) > 0) j--;
            if(i <= j) switchPositions(toSort, i++, j--);
        }
        if(from < j) sort(toSort, from, j);
        if(i < to) sort(toSort, i, to);
    }

    /**
     * Internal call used by public sort function
     * @param toSort array to sort
     * @param from index to start sorting
     * @param to index to stop sorting
     * credits to: http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
     */
    @Magic
    private void sort(T[] toSort, int from, int to){
        T pivot = toSort[ (from + to) / 2 ];
        int i = from, j = to;

        while(i <= j) {
            while(toSort[i].compareTo(pivot) < 0) i++;
            while(toSort[j].compareTo(pivot) > 0) j--;
            if(i <= j) switchPositions(toSort, i++, j--);
        }
        if(from < j) sort(toSort, from, j);
        if(i < to) sort(toSort, i, to);
    }

    /**
     * Used in sort to change the positions of two index values
     * @param toSort array to sort
     * @param from left index to switch
     * @param to right index to switch
     */
    private void switchPositions(MemoryCell<T>[] toSort, int from, int to) {
        MemoryCell<T> temp = toSort[ from ];
        toSort[ from ] = toSort[ to ];
        toSort[ to ] = temp;
    }

    /**
     * Used in sort to change the positions of two index values
     * @param toSort array to sort
     * @param from left index to switch
     * @param to right index to switch
     */
    private void switchPositions(T[] toSort, int from, int to) {
        T temp = toSort[ from ];
        toSort[ from ] = toSort[ to ];
        toSort[ to ] = temp;
    }
}
