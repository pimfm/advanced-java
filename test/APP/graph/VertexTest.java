package APP.graph;

import nl.HAN.ASD.APP.graph.Vertex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pim van Gurp, 9/28/2015.
 */
public class VertexTest {
    private Vertex v;

    @Before
    public void setUp() throws Exception {
        v = new Vertex("Apeldoorn");
    }

    @Test
    public void testSetDistance() throws Exception {
        v.setDistance(345);
        assertEquals(345, v.getDistance(), 0.0001);
    }

    @Test
    public void testGetDistance() throws Exception {
        v.setDistance(345);
        assertEquals(345, v.getDistance(), 0.0001);
    }

    @Test
    public void testGetPrevious() throws Exception {
        assertNull(v.getPrevious());

        v.setPrevious(new Vertex("Arnhem"));
        assertEquals("Arnhem", v.getPrevious().getName());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Apeldoorn", v.getName());
    }
}