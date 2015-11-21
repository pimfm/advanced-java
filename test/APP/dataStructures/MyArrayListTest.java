package APP.dataStructures;

import nl.HAN.ASD.APP.dataStructures.MyArrayList;
import nl.HAN.ASD.APP.generics.Shape;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pim van Gurp, 9/9/2015.
 */
public class MyArrayListTest {
    private MyArrayList<Integer> list;

    @Before
    public void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    public void testSize() {
        assertEquals("Starts with size 0", 0, list.size());

        list.add(12);
        list.add(13);
        assertEquals("Size 2 after 2 adds", 2, list.size());

        list.remove(1);
        list.remove(0);
        list.add(1);
        assertEquals("Size 1 aster 2 remove 1 add", 1, list.size());
    }
    
    @Test
    public void testRemove() {
        assertNull(list.remove(0));

        list.add(14);
        int actual = list.remove(0);
        assertEquals("Removed element value 14", 14, actual);

        list.add(15);
        list.add(12);
        list.remove(0);
        list.add(14);
        list.add(555);
        list.remove(1);
        assertEquals("Check size after removing", 2, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue("Initial state empty", list.isEmpty());

        list.add(15);
        assertFalse("False after adding", list.isEmpty());

        list.remove(0);
        assertTrue("True after removing", list.isEmpty());
    }

    @Test
    public void testGet() {
        list.add(55);
        list.add(66);
        list.add(77);
        int actual = list.get(1);
        assertEquals(66, actual);

        actual = list.get(1);
        assertEquals(66, actual);
    }

    @Test
    public void testSet() {
        list.add(55);
        list.add(66);
        list.add(77);
        list.set(1, 65);
        assertEquals(65, (int) list.get(1));
        assertEquals(77, (int) list.get(2));
    }

    @Test
    public void testAdd() {
        list.add(55);
        int actual = list.get(0);
        assertEquals(55, actual);
    }

    @Test
    public void testToArray() {
        Object[] expected = new Integer[]{5, 6, 19, 22, null, null, null};
        list.add(5);
        list.add(6);
        list.add(19);
        list.add(22);
        Object[] actual = list.toArray();
        assertArrayEquals(expected, actual);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void isGeneric() {
        MyArrayList<String> strings = new MyArrayList<>();
        strings.add("Gurp");
        strings.add("van");
        strings.add("Pim");
        assertEquals("Gurp", strings.get(0));

        MyArrayList<Shape> shapes = new MyArrayList<>();
        shapes.add(new Shape());
        shapes.add(new Shape());
        assertTrue(shapes.get(1) instanceof Shape);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wrongInputThrowsException() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.get(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidInputThrowsException() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.set(5, 17);
    }
}