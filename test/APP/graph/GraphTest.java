package APP.graph;

import nl.HAN.ASD.APP.graph.Graph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pim van Gurp, 9/18/2015.
 */
public class GraphTest {
    private Graph graph;

    @Before
    public void setUp() throws Exception {
        graph = new Graph();
        graph.addEdge("Apeldoorn", "Arnhem", 33.1);
        graph.addEdge("Apeldoorn", "Teuge", 6.6);
        graph.addEdge("Apeldoorn", "Deventer", 20.5);
        graph.addEdge("Teuge", "Deventer", 11.1);
        graph.addEdge("Teuge", "Twello", 0.1);
        graph.addEdge("Twello", "Deventer", 0.1);
        graph.addEdge("Deventer", "Enschede", 0.1);
    }

    @Test
    public void testAddVertex() throws Exception {
        graph.addVertex("Den Haag");
        graph.addVertex("Utrecht");
        assertEquals("Utrecht", graph.getVertex("Utrecht").getName());
    }

    @Test
    public void testIsConnectedTrue() throws Exception {
        assertTrue(graph.isConnected());
    }

    @Test
    public void testIsConnectedFalse() throws Exception {
        graph.addEdge("Hamburg", "Kopenhagen", 12);
        assertFalse(graph.isConnected());
    }

    @Test
    public void testIsConnectedEmpty() {
        Graph g = new Graph();
        assertTrue(g.isConnected());
    }
}