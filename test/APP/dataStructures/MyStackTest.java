package APP.dataStructures;

import nl.HAN.ASD.APP.TOETS_29092015.PStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pim van Gurp, 9/10/2015.
 */
public class MyStackTest {
    private PStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new PStack<>();
    }

    @Test
    public void testPop() {
        stack.push(55);
        stack.push(44);
        stack.push(66);
        assertEquals(66, (int) stack.pop());
        assertEquals(44, (int) stack.pop());
    }

    @Test
    public void testPush() {
        stack.push(45);
        stack.push(55);
        stack.push(54);
        assertEquals(54, (int) stack.pop());
    }

    @Test
    public void testTop() {
        stack.push(56);
        stack.push(77);
        stack.push(34);
        assertEquals(34, (int) stack.top());
        assertEquals(34, (int) stack.top());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push(19);

        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPrint() {
        stack.push(18);
        stack.push(19);
        stack.push(20);
        stack.print();
    }
}