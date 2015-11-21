package nl.HAN.ASD.APP.graph;

/**
 * Created by Pim van Gurp, 9/16/2015.
 */
public class Edge {
    /**
     * Destination object
     */
    private Vertex dest;

    /**
     * Cost to get to the destination
     */
    private double cost;

    /**
     * Create a new Edge
     * @param dest destination of edge
     * @param cost cost to get to destination
     */
    public Edge(Vertex dest, double cost) {
        this.dest = dest;
        this.cost = cost;
    }

    /**
     * Get cost to destination
     * @return cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Get the destination object
     * @return destination
     */
    public Vertex getDestination() {
        return dest;
    }

    /**
     * Give a meaningful String representing this edge
     * @return String representation
     */
    public String toString() {
        return "("+ dest.getName() +", "+ cost +")";
    }
}
