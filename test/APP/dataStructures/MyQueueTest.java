package APP.dataStructures;

import nl.HAN.ASD.APP.dataStructures.MyQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pim van Gurp, 9/10/2015.
 */
public class MyQueueTest {
    private MyQueue<Integer> queue;
    
    @Before
    public void setUp() {
        queue = new MyQueue<>();
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(28);
        queue.enqueue(99);
        assertEquals(28, (int) queue.peek());
    }

    @Test
    public void testDequeue() {
        queue.enqueue(88);
        queue.enqueue(99);
        queue.enqueue(111);

        int actual = queue.dequeue();
        assertEquals(88, actual);
        assertEquals(99, (int) queue.peek());
    }

    @Test
    public void testPeek() {
        queue.enqueue(77);
        queue.enqueue(88);
        queue.dequeue();
        queue.enqueue(45);
        assertEquals(88, (int) queue.peek());
    }
}