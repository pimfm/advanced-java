package APP.generics;

import nl.HAN.ASD.APP.generics.Square;
import nl.HAN.ASD.APP.generics.Generic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pim van Gurp, 9/8/2015.
 */
public class GenericTest {

    @Test
    public void testMinArrayInt() {
        Integer[] ints = new Integer[]{8, 9, 1, 4, 3, 5, 6, 7, 8};
        int actual = new Generic<Integer>().min(ints);
        assertEquals("testMinArrayInt", 1, actual);
    }

    @Test
    public void testMinArrayDouble() {
        Double[] doubles = new Double[]{1.2, 4.4, 3.2, 5.5, 6.5, 7.4, 8.2};
        double actual = new Generic<Double>().min(doubles);
        assertEquals("testMinArrayDouble", 1.2, actual, 0.0001);
    }

    @Test
    public void testMinArrayString() {
        String[] strings = new String[]{"Baas", "Saab", "Kaas", "Saak", "3"};
        String actual = new Generic<String>().min(strings);
        assertEquals("testMinArrayString", "3", actual);
    }

    @Test
    public void testMinArraySquare() {
        Square[] squares = new Square[]{new Square(29), new Square(30), new Square(22)};
        Square actual = new Generic<Square>().min(squares);
        assertEquals("testMinArrayInt", 22, actual.getArea());
    }

    @Test
    public void testMinInt() {
        int actual = new Generic<Integer>().min(1, 2);
        assertEquals("testMinInt", 1, actual);
    }

    @Test
    public void testMinDouble() {
        double actual = new Generic<Double>().min(8.2, 9.1);
        assertEquals("testMinDouble", 8.2, actual, 0.0001);
    }

    @Test
    public void testMaxArrayInt() {
        Integer[] ints = new Integer[]{8, 9, 1, 4, 3, 5, 6, 7, 8};
        int actual = new Generic<Integer>().max(ints);
        assertEquals("testMaxArrayInt", 9, actual);
    }

    @Test
    public void testMaxArrayDouble() {
        Double[] doubles = new Double[]{1.2, 4.4, 3.2, 5.5, 6.5, 7.4, 8.2};
        double actual = new Generic<Double>().max(doubles);
        assertEquals("testMaxArrayDouble", 8.2, actual, 0.0001);
    }

    @Test
    public void testMaxArrayString() {
        String[] strings = new String[]{"Baas", "Saab", "Kaas", "Saak", "3"};
        String actual = new Generic<String>().max(strings);
        assertEquals("testMaxArrayString", "Saak", actual);
    }

    @Test
    public void testMaxArraySquare() {
        Square[] squares = new Square[]{new Square(29), new Square(30), new Square(22)};
        Square actual = new Generic<Square>().max(squares);
        assertEquals("testMaxArrayInt", 30, actual.getArea());
    }

    @Test
    public void testMaxInt() {
        int actual = new Generic<Integer>().max(1, 2);
        assertEquals("testMaxInt", 2, actual);
    }

    @Test
    public void testMaxDouble() {
        double actual = new Generic<Double>().max(8.2, 9.1);
        assertEquals("testMaxDouble", 9.1, actual, 0.0001);
    }
}