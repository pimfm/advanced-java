package nl.HAN.ASD.APP.sorting;

import nl.HAN.ASD.APP.generics.MemoryCell;

import java.util.Arrays;

/**
 * Created by Pim van Gurp, 9/6/2015.
 */
public class SortingMain {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ISorter<Integer> quick = new Quick<>();
        ISorter<Integer> merge = new Merge<>();
        ISorter<Integer> insertion = new Insertion<>();
        SorterHelper helper = new SorterHelper();

        MemoryCell<Integer>[] mergeResult = merge.sort(helper.randomArray(100, 50));
        MemoryCell<Integer>[] quickResult = quick.sort(helper.randomArray(100, 50));
        MemoryCell<Integer>[] insertionResult = insertion.sort(helper.randomArray(100, 50));

        System.out.println(Arrays.toString(helper.randomArray(100, 50)));
        System.out.println(Arrays.toString(insertionResult));
        System.out.println(Arrays.toString(merge.sort(mergeResult)));
        System.out.println(Arrays.toString(quick.sort(quickResult)));

        System.out.println("Arrays are sorted: " + helper.isSorted(mergeResult) + ", "
                + helper.isSorted(quickResult) + ", " + helper.isSorted(insertionResult));
    }
}

