package nl.HAN.ASD.APP.graph;

import nl.HAN.ASD.APP.dataStructures.*;
import nl.HAN.ASD.APP.dataStructures.LinkedList.MyLinkedList;

/**
 * Created by Pim van Gurp, 9/16/2015.
 */
public class Graph {
    /**
     * A map of all vertices(locations)
     */
    private MyHashMap<Vertex> vertices;

    /**
     * Constructor for a new Graph
     */
    public Graph() {
        vertices = new MyHashMap<>();
    }

    /**
     * Calculate the shortestPath from a vertex to
     * another vertex
     * @param from beginning of path
     * @param to end of path
     * @return the shortest from the begin vertex to the end
     */
    public Edge[] shortestPath(String from, String to) {
        Vertex source = vertices.lookup(from);
        Vertex destination = vertices.lookup(to);
        dijkstra(source, true); //Second parameter indicates weighted(true) or unweighted(false)
        return calculatePath(destination);
    }

    /**
     * Return the calculated path as a set of edges
     * @param destination place to calculate the path to
     * @return list of edges intermediate of the destination
     */
    private Edge[] calculatePath(Vertex destination) {
        MyLinkedList<Edge> list = new MyLinkedList<>();
        Vertex v = destination;
        while(v.getPrevious() != null) {
            list.add(new Edge(v, v.getDistance()));
            v = v.getPrevious();
        }
        list.add(new Edge(v, v.getDistance()));
        return list.toArray(new Edge[list.size()]);
    }

    /**
     * Use dijkstra algorithm to calculate distances to
     * all vertices from the source
     * @param source place to calculate cost to
     * @param weighted values to edges or the edge itself
     */
    private void dijkstra(Vertex source, boolean weighted) {
        resetDistances();
        MyQueue<Vertex> q = new MyQueue<>();
        q.enqueue(source);
        source.setDistance(0);

        while( !q.isEmpty() ) {
            Vertex from = q.dequeue();

            for(Edge e : from.getEdges()) {
                Vertex to = e.getDestination();
                q.enqueue(to);

                double extra = (weighted) ? e.getCost() : 1.0;
                double distance = from.getDistance() + extra;
                if(distance < to.getDistance()) {
                    to.setDistance(distance);
                    to.setPrevious(from);
                }
            }
        }
    }

    /**
     * Check if any vertex can access any
     * other vertex in the graph
     * @return 1 graph is connected
     *         0 graph is not connected
     */
    public boolean isConnected() {
        resetDistances();
        MyArrayList<String> keys = vertices.keySet();
        if(keys.isEmpty()) return true;
        dijkstra( vertices.lookup(keys.get(0)), false);

        for (String key : keys) {
            Vertex v = vertices.lookup(key);
            if (v.getDistance() == Double.MAX_VALUE) {
                return false;
            }
        }
        return true;
    }

    /**
     * Add a new vertex to the graph
     * @param name name of the new vertex
     * @return the added vertex
     */
    public Vertex addVertex(String name) {
        Vertex newVertex = new Vertex(name);
        vertices.put(name, newVertex);
        return newVertex;
    }

    /**
     * Add a new edge to the graph
     * @param from source of edge
     * @param to destination of edge
     * @param cost cost to get to the destination from the source
     */
    public void addEdge(String from, String to, double cost) {
        Vertex source = (vertices.lookup(from) == null) ? addVertex(from) : getVertex(from);
        Vertex destination = (vertices.lookup(to) == null) ? addVertex(to) : getVertex(to);

        source.addEdge( new Edge(destination, cost) );
    }

    /**
     * Used to clear all distances to calculate again
     */
    private void resetDistances() {
        MyArrayList<String> keys = vertices.keySet();

        for (String key : keys) {
            Vertex v = vertices.lookup(key);
            v.reset();
        }
    }

    /**
     * Return the graph as a String
     * @return String representation of the graph
     */
    @Override
    public String toString() {
        if(vertices.isEmpty()) {
            return "Graph is empty.";
        }

        String result = "";
        MyArrayList<String> keys = vertices.keySet();

        for (String key : keys) {
            Vertex v = vertices.lookup(key);
            result += "" + v.getName() + ": [" + v.edgesAsString() + "]";
            result += "\n";
        }

        return result;
    }

    /**
     * Get a vertex in the graph
     * @param name name of the vertex
     * @return found vertex in the hashMap
     */
    public Vertex getVertex(String name) {
        return vertices.lookup(name);
    }
}
