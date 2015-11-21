package APP.dataStructures;

import nl.HAN.ASD.APP.dataStructures.LinkedList.MyLinkedList;
import nl.HAN.ASD.APP.generics.Shape;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pim van Gurp, 9/10/2015.
 */
public class MyLinkedListTest {
    private MyLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new MyLinkedList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);
    }

    @Test
    public void testAddFirst()  {
        list.add(24);
        assertEquals(24, (int) list.get(0).getValue());

        list.add(12);
        assertEquals(12, (int) list.remove().getValue());
    }

    @Test
    public void testRemoveFirst()  {
        list.remove();
        list.remove();
        assertEquals(33, (int) list.get(0).getValue());
    }

    @Test
    public void testInsert()  {
        list.insert(2, 56);
        assertEquals(44, (int) list.get(1).getValue());
        assertEquals(56, (int) list.get(2).getValue());
        assertEquals(33, (int) list.get(3).getValue());
    }

    @Test
    public void testDelete()  {
        list.delete(2);
        assertEquals(44, (int) list.get(1).getValue());
        assertEquals(22, (int) list.get(2).getValue());
        assertEquals(11, (int) list.get(3).getValue());
    }

    @Test
    public void testGet()  {
        assertEquals(33, (int) list.get(2).getValue());
        assertEquals(55, (int) list.get(0).getValue());
        assertEquals(11, (int) list.get(4).getValue());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void isGeneric() {
        MyLinkedList<String> strings = new MyLinkedList<>();
        strings.add("testing");
        strings.add("just");
        assertEquals("just", strings.get(0).getValue());

        MyLinkedList<Shape> shapes = new MyLinkedList<>();
        shapes.add(new Shape());
        shapes.add(new Shape());
        assertTrue(shapes.get(0).getValue() instanceof Shape);
    }
}