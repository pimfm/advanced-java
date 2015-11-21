package APP.sorting;

import nl.HAN.ASD.APP.generics.MemoryCell;
import nl.HAN.ASD.APP.sorting.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pim van Gurp, 9/26/2015.
 */
@SuppressWarnings("unchecked")
public class InsertionTest {
    private ISorter insertion;
    private SorterHelper helper;
    private MemoryCell<Integer>[] toSort, expected;
    private int LENGTH;

    @Before
    public void initialize() {
        LENGTH = 100;   //Amount of elements in array
        int MAX = 50;
        insertion = new Insertion<Integer>();
        helper = new SorterHelper();
        toSort = helper.randomArray(LENGTH, MAX);
    }

    @Test
    public void randomReturnsFilledArray() {
        assertEquals("Length of array is same as length", LENGTH, toSort.length);
    }

    @Test
    public void insertionSortReturnsArray() {
        //noinspection ConstantConditions
        assertTrue("InsertionSort returns array", insertion.sort(toSort) instanceof MemoryCell[]);
    }

    @Test
    public void insertionSortSorts() {
        assertTrue("The result from insertionSort is sorted", helper.isSorted(insertion.sort(toSort)));
    }

    @Test
    public void insertionSortRandomInput() {
        toSort = helper.toMemoryCellArray(new Integer[]{1, 5, 3, 6, 7, 3, 7, 22, 99});
        expected = helper.toMemoryCellArray(new Integer[]{1, 3, 3, 5, 6, 7, 7, 22, 99});
        assertTrue("InsertSort sorts actual as expected", helper.equals(expected, insertion.sort(toSort)));
    }

    @Test
    public void insertionAlreadySorted() {
        toSort = helper.toMemoryCellArray(new Integer[]{1, 3, 3, 5, 6, 7, 7, 22, 99});
        expected = helper.toMemoryCellArray(new Integer[]{1, 3, 3, 5, 6, 7, 7, 22, 99});
        assertTrue("InsertionSort can sort already sorted array", helper.equals(expected, insertion.sort(toSort)));
    }

    @Test
    public void insertionReversed() {
        toSort = helper.toMemoryCellArray(new Integer[]{66, 45, 34, 34, 22, 18, 12, 8, 6, 5, 2, 1});
        expected = helper.toMemoryCellArray(new Integer[]{1, 2, 5, 6, 8, 12, 18, 22, 34, 34, 45, 66});
        assertTrue("InsertionSort can handle inverted sorted array", helper.equals(expected, insertion.sort(toSort)));
    }

    @Test
    public void insertionNegative() {
        toSort = helper.toMemoryCellArray(new Integer[]{-1, -5, 6, 2, -8});
        expected = helper.toMemoryCellArray(new Integer[]{-8, -5, -1, 2, 6});
        assertTrue("InsertionSort can sort negative values", helper.equals(expected, insertion.sort(toSort)));
    }

    @Test
    public void insertionEmpty() {
        toSort = new MemoryCell[0];
        expected = new MemoryCell[0];
        assertTrue("InsertionSort returns empty array when given", helper.equals(expected, insertion.sort(toSort)));
    }

    @Test
    public void insertionSameValues() {
        toSort = helper.toMemoryCellArray(new Integer[]{8, 8, 8, 8, 8, 8, 8, 8});
        expected = helper.toMemoryCellArray(new Integer[]{8, 8, 8, 8, 8, 8, 8, 8});
        assertTrue("InsertionSort returns same when all values identical", helper.equals(expected, insertion.sort(toSort)));
    }
}