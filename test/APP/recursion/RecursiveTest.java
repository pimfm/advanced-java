package APP.recursion;

import nl.HAN.ASD.APP.recursion.Recursive;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pim van Gurp, 9/11/2015.
 */
public class RecursiveTest {
    private Recursive recursive;

    @Before
    public void setUp() {
        recursive = new Recursive();
    }

    @Test
    public void testFactorial() {
        assertEquals(1, recursive.factorial(0));
        assertEquals(1, recursive.factorial(1));
        assertEquals(120, recursive.factorial(5));
    }

    @Test
    public void testSum() {
        assertEquals(0, recursive.sum(0));
        assertEquals(1, recursive.sum(1));
        assertEquals(15, recursive.sum(5));
    }

    @Test
    public void testBinaryCount() {
        assertEquals(0, recursive.binaryCount(0));
        assertEquals(1, recursive.binaryCount(1));
        assertEquals(2, recursive.binaryCount(5));
    }

    @Test
    public void testReverse() {
        assertEquals("tseT", recursive.reverse("Test"));
        assertEquals("t", recursive.reverse("t"));
        assertEquals("level", recursive.reverse("level"));
    }
}