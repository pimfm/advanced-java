package APP.generics;

import nl.HAN.ASD.APP.generics.MemoryCell;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pim van Gurp, 9/8/2015.
 */
public class MemoryCellTest {
    private MemoryCell<Integer> a, b;

    @Before
    public void setUp() {
        a = new MemoryCell<>();
        b = new MemoryCell<>();
    }

    @Test
    public void testReadAndWrite() {
        MemoryCell<Integer> a = new MemoryCell<>();
        a.write(20);
        assertEquals(20, (int) a.read());

        MemoryCell<String> b = new MemoryCell<>();
        b.write("Let's test");
        assertEquals("Let's test", b.read());
    }

    @Test
    public void testCompareToSmaller() {
        a.write(10);
        b.write(11);
        int actual = a.compareTo( b );
        assertEquals("compareToSmallerPositive", -1, actual);
    }

    @Test
    public void testCompareToBigger() {
        a.write(12);
        b.write(11);
        int actual = a.compareTo( b );
        assertEquals("compareToBiggerPositive", 1, actual);
    }

    @Test
    public void testCompareToEqual() {
        a.write(12);
        b.write(12);
        int actual = a.compareTo( b );
        assertEquals("compareToEqualPositive", 0, actual);
    }
}