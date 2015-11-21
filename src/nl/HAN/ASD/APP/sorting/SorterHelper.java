package nl.HAN.ASD.APP.sorting;

import nl.HAN.ASD.APP.generics.MemoryCell;

import java.util.Random;

/**
 * Created by Pim van Gurp, 9/25/2015.
 */
public class SorterHelper {
    /**
     * Constructor for sorter class. Initialized with an array
     * of random integers with a custom width and max value
     * @param length amount of elements in array
     * @param max max value of a single element in array
     */
    @SuppressWarnings("unchecked")
    public MemoryCell<Integer>[] randomArray(int length, int max) {
        MemoryCell<Integer>[] array = new MemoryCell[length];
        Random generator = new Random();
        MemoryCell<Integer> toAdd;
        for(int i = 0; i < length; i++) {
            toAdd = new MemoryCell<>();
            toAdd.write(generator.nextInt(max));
            array[i] = toAdd;
        }
        return array;
    }

    /**
     * Constructor for sorter class. Initialized with an array
     * of random integers with a custom width and max value
     * @param length amount of elements in array
     * @param max max value of a single element in array
     */
    @SuppressWarnings("unchecked")
    public Integer[] randomIntArray(int length, int max) {
        Integer[] array = new Integer[length];
        Random generator = new Random();
        Integer toAdd;
        for(int i = 0; i < length; i++) {
            toAdd = generator.nextInt(max);
            array[i] = toAdd;
        }
        return array;
    }


    /**
     * Used to Tokenizer if an array is already sorted
     * @return true is array is sorted and false if array is not already sorted.
     */
    public <T extends Comparable<? super T>> boolean isSorted(MemoryCell<T>[] toSort) {
        for (int i = 0; i < toSort.length - 1; i++) {
            if (toSort[i].compareTo(toSort[i+1]) > 0) return false;
        }
        return true;
    }

    /**
     * Check if all the values inside the memory cells equal.
     * @param arr1 first array to Tokenizer for equality with arr2
     * @param arr2 compare to arr1
     * @param <T> generic content in memory cell, must implement Comparable
     * @return 1 arrays equal
     *         0 arrays do not equal
     */
    public <T extends Comparable<? super T>> boolean equals(MemoryCell<T>[] arr1, MemoryCell<T>[] arr2) {
        if(arr1 == null || arr2 == null) throw new NullPointerException();
        if(arr1.length != arr2.length) return false;

        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] == null && arr2[i] != null ) return false;
            if(arr2[i] == null && arr1[i] != null ) return false;
            if(arr2[i] == null && arr2[i] == null ) continue;

            if(arr1[i].compareTo(arr2[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Convert a generic array of any comparable type to a
     * memoryCell array with the values as read value
     * @param array array to convert
     * @param <T> Generic type that implements comparable
     * @return MemoryCell array with values from old array
     */
    @SuppressWarnings("unchecked")
    public <T extends Comparable<? super T>> MemoryCell<T>[] toMemoryCellArray(T[] array) {
        MemoryCell<T>[] result = new MemoryCell[array.length];

        for(int i = 0; i < array.length; i++) {
            MemoryCell<T> mc = new MemoryCell<>();
            mc.write(array[i]);
            result[i] = mc;
        }
        return result;
    }
}
