package APP.generics;

import nl.HAN.ASD.APP.generics.Square;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pim van Gurp, 9/8/2015.
 */
public class SquareTest {
    private Square square;

    @Before
    public void setUp() {
        square = new Square(40);
    }

    @Test
    public void testCompareToSmaller() {
        int actual = square.compareTo( new Square(41) );
        assertEquals("compareToSmallerPositive", -1, actual);

        square = new Square(-2);
        actual = square.compareTo( new Square(-1) );
        assertEquals("compareToSmallerNegative", -1, actual);
    }

    @Test
    public void testCompareToBigger() {
        int actual = square.compareTo( new Square(39) );
        assertEquals("compareToBiggerPositive", 1, actual);

        square = new Square(-2);
        actual = square.compareTo( new Square(-3) );
        assertEquals("compareToBiggerNegative", 1, actual);
    }

    @Test
    public void testCompareToEqual() {
        int actual = square.compareTo( new Square(40) );
        assertEquals("compareToEqualPositive", 0, actual);

        square = new Square(-2);
        actual = square.compareTo( new Square(-2) );
        assertEquals("compareToEqualNegative", 0, actual);
    }
}