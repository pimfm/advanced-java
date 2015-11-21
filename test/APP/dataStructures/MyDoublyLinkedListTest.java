package APP.dataStructures;

import nl.HAN.ASD.APP.dataStructures.LinkedList.MyDoublyLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pim van Gurp, 9/26/2015.
 */
public class MyDoublyLinkedListTest {
    private MyDoublyLinkedList<Integer> doubly;

    @Before
    public void setUp() {
        doubly = new MyDoublyLinkedList<>();
        doubly.add(11);
        doubly.add(22);
        doubly.add(33);
        doubly.add(44);
        doubly.add(55);
        doubly.add(66);
        doubly.add(77);
        doubly.add(88);
        doubly.add(99);
    }
    
    @Test
    public void testInsertSmall() {
        doubly.insert(4, 17);

        assertEquals(66, (int) doubly.get(3).getValue());
        assertEquals(17, (int) doubly.get(4).getValue());
        assertEquals(55, (int) doubly.get(5).getValue());
    }

    @Test
    public void testInsertBig() {
        doubly.insert(5, 17);

        assertEquals(55, (int) doubly.get(4).getValue());
        assertEquals(17, (int) doubly.get(5).getValue());
        assertEquals(44, (int) doubly.get(6).getValue());
    }

    @Test
    public void testDeleteSmall() {
        doubly.delete(3);

        assertEquals(77, (int) doubly.get(2).getValue());
        assertEquals(55, (int) doubly.get(3).getValue());
        assertEquals(44, (int) doubly.get(4).getValue());
    }

    @Test
    public void testDeleteBig() {
        doubly.delete(6);

        assertEquals(44, (int) doubly.get(5).getValue());
        assertEquals(22, (int) doubly.get(6).getValue());
        assertEquals(11, (int) doubly.get(7).getValue());
    }

    @Test
    public void testAdd() {
        doubly.add(23);

        assertEquals(23, (int) doubly.remove().getValue());
    }

    @Test
    public void testGet() {
        assertEquals(99, (int) doubly.get(0).getValue());
        assertEquals(77, (int) doubly.get(2).getValue());
        assertEquals(44, (int) doubly.get(5).getValue());
    }

    @Test
    public void testRemove() {
        assertEquals(99, (int) doubly.remove().getValue());
        assertEquals(88, (int) doubly.remove().getValue());
    }

    @Test
    public void testRemoveLast() {
        assertEquals(11, (int) doubly.removeLast().getValue());
        assertEquals(22, (int) doubly.removeLast().getValue());
    }

    @Test
    public void testAddLast() {
        doubly.addLast(23);

        assertEquals(23, (int) doubly.get(9).getValue());
        assertEquals(11, (int) doubly.get(8).getValue());
    }

    @Test
    public void testSize() {
        assertEquals(9, doubly.size());
        doubly.reset();
        assertEquals(0, doubly.size());
    }

    @Test
    public void testIsNotEmpty() {
        assertFalse(doubly.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        doubly.reset();
        assertTrue(doubly.isEmpty());
    }
}