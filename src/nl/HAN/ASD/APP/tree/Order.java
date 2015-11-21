package nl.HAN.ASD.APP.tree;

/**
 * Created by Pim van Gurp, 9/27/2015.
 */
public enum Order {
    /**
     * Represents an order to print a tree
     * PRE: current, left, right
     * IN: left, current, right
     * POST: left, right, current
     */
    PRE, IN, POST
}
