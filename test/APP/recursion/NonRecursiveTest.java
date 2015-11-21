package APP.recursion;

import nl.HAN.ASD.APP.recursion.NonRecursive;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pim van Gurp, 9/28/2015.
 */
public class NonRecursiveTest {
    private NonRecursive nr;

    @Before
    public void setUp() throws Exception {
        nr = new NonRecursive();
    }

    @Test
    public void testFactorial() throws Exception {
        assertEquals(120, nr.factorial(5));
        assertEquals(1, nr.factorial(1));
        assertEquals(1, nr.factorial(0));
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(0, nr.sum(0));
        assertEquals(1, nr.sum(1));
        assertEquals(15, nr.sum(5));
    }
}