package nl.HAN.ASD.APP.graph;

import nl.HAN.ASD.APP.dataStructures.LinkedList.MyLinkedList;

/**
 * Created by Pim van Gurp, 9/16/2015.
 */
public class Vertex {
    /**
     * Name of the vertex.
     * A string key
     */
    private String name;

    /**
     * The edges this vertex can reach
     */
    private MyLinkedList<Edge> edges;

    /**
     * The previous vertex that has the least
     * cost to this vertex
     */
    private Vertex prev;

    /**
     * Total distance from vertex to vertex
     * to get to this vertex
     */
    private double distance;

    /**
     * Create a new Vertex
     * @param name String key of vertex
     */
    public Vertex(String name) {
        this.name = name;
        this.edges = new MyLinkedList<>();
        reset();
    }

    /**
     * Clear all calculated values of the
     * current vertex
     */
    public void reset() {
        this.distance = Double.MAX_VALUE;
        prev = null;
    }

    /**
     * Add a destination/edge the current
     * vertex can reach
     * @param edge path to a destination
     */
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    /**
     * Get all the destinations this vertex can reach
     * @return list of edges
     */
    public Edge[] getEdges() {
        return edges.toArray(new Edge[edges.size()]);
    }

    /**
     * Used to set the calculated total distance
     * to this vertex
     * @param distance total distance to this vertex
     */
    public void setDistance(double distance) {
        this.distance = Math.round( distance * 100.0 ) / 100.0;
    }

    /**
     * Get the distance to this vertex
     * @return total distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Check which vertex was accessed
     * before reaching this one
     * @return the previous reached vertex
     */
    public Vertex getPrevious() {
        return prev;
    }

    /**
     * Set the vertex accessed before
     * this vertex
     * @param prev previous vertex
     */
    public void setPrevious(Vertex prev) {
        this.prev = prev;
    }

    /**
     * Return all the edges this vertex can
     * reach in a String format
     * @return String representation of edges list
     */
    public String edgesAsString() {
        return edges.toString();
    }

    /**
     * Get the name of this vertex
     * @return name of vertex
     */
    public String getName() {
        return name;
    }

    /**
     * Return a list edges this vertex can reach
     * with its name as a String
     * @return String representation
     */
    @Override
    public String toString() {
        return "{"+ name +": ("+ prev +", "+ distance +")}";
    }
}
