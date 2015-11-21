package nl.HAN.ASD.APP.sorting;

import nl.HAN.ASD.APP.generics.MemoryCell;

/**
 * Created by Pim van Gurp, 9/7/2015.
 */
public interface ISorter<T extends Comparable<? super T>> {
    MemoryCell<T>[] sort(MemoryCell<T>[] toSort);
    T[] sort(T[] toSort);
}
