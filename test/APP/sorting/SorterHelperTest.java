package APP.sorting;

import nl.HAN.ASD.APP.generics.MemoryCell;
import nl.HAN.ASD.APP.sorting.SorterHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Pim van Gurp, 9/26/2015.
 */
public class SorterHelperTest {
    private SorterHelper helper;

    @Before
    public void setup() {
        helper = new SorterHelper();
    }

    @Test
    public void testRandomArray() {
        MemoryCell<Integer>[] randomArray = helper.randomArray(100, 50);

        assertTrue(randomArray[0].read() >= 0 && randomArray[0].read() < 50);
        assertTrue(randomArray[22].read() >= 0 && randomArray[22].read() < 50);
        assertTrue(randomArray[88].read() >= 0 && randomArray[88].read() < 50);
        assertTrue(randomArray[99].read() >= 0 && randomArray[99].read() < 50);
    }

    @Test
    public void testToMemoryCellArray() {
        MemoryCell<Integer>[] mcArray = helper.toMemoryCellArray(new Integer[]{1, 2, 5, 6, 8, 12, 18, 22, 34, 34, 45, 66});

        assertEquals(5, (int) mcArray[2].read());
        assertEquals(1, (int) mcArray[0].read());
        assertEquals(22, (int) mcArray[7].read());
    }

    @Test
    public void testIsSorted() {
        MemoryCell<Integer>[] sortedArray = helper.toMemoryCellArray(new Integer[]{1, 2, 5, 6, 8, 12, 18, 22, 34, 34, 45, 66});
        MemoryCell<Integer>[] unsortedArray = helper.toMemoryCellArray(new Integer[]{8, 14, 2, 5, 6, 8, 12, 18, 22, 34, 34, 45, 66});

        assertTrue( helper.isSorted( sortedArray ) );
        assertFalse( helper.isSorted( unsortedArray ) );
    }

    @Test
    public void testEquals() {
        MemoryCell<Integer>[] arr1 = helper.toMemoryCellArray(new Integer[]{1, 2, 5, 6, 8, 12, 18, 22, 34, 34, 45, 66});
        MemoryCell<Integer>[] arr2 = helper.toMemoryCellArray(new Integer[]{1, 2, 5, 6, 8, 12, 18, 22, 34, 34, 45, 66});
        MemoryCell<Integer>[] arr3 = helper.toMemoryCellArray(new Integer[]{7, 8, 2, 5, 6, 8, 12, 18, 22, 34, 34, 45, 66});

        assertTrue( helper.equals( arr1, arr2 ) );
        assertFalse( helper.equals( arr2, arr3 ) );
    }
}