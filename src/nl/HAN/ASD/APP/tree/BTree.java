package nl.HAN.ASD.APP.tree;

import java.security.InvalidParameterException;

/**
 * Created by Pim van Gurp, 9/27/2015.
 */
public class BTree<T>{
    /**
     * Value set in the current node
     */
    private T value;

    /**
     * Tree hanging on the left side
     */
    private BTree<T> left;

    /**
     * Tree hanging on the right side
     */
    private BTree<T> right;

    /**
     * Empty constructor
     */
    public BTree() {}

    /**
     * Constructor that sets current value
     * @param value content to store in tree
     */
    public BTree(T value) {
        this.value = value;
    }

    /**
     * Get the tree hanging on the right
     * of the root
     * @return tree on right
     */
    public BTree<T> getRight() { return right; }

    /**
     * Get the tree hanging on the left
     * of the root
     * @return tree on left
     */
    public BTree<T> getLeft() { return left; }

    /**
     * Add a new tree with a value to
     * the left of this tree
     * @param value content of left tree
     * @return added tree
     */
    public BTree<T> addLeft(T value) {
        left = new BTree<>(value);
        return left;
    }

    /**
     * Add a new tree to the left side
     * of this tree
     * @param left tree to add to the left
     * @return added tree
     */
    public BTree<T> addLeft(BTree<T> left) {
        this.left = left;
        return left;
    }

    /**
     * Add a new tree with a value to
     * the right of this tree
     * @param value content of right tree
     * @return added tree
     */
    public BTree<T> addRight(T value) {
        right = new BTree<>(value);
        return right;
    }

    /**
     * Add a new tree to the right side
     * of this tree
     * @param right tree to add to the right
     * @return added tree
     */
    public BTree<T> addRight(BTree<T> right) {
        this.right = right;
        return right;
    }

    /**
     * Return a string of the entire tree.
     * used for printing
     * @param depth used for alignment, use -1 for no alignment
     * @param order PRE, POST and IN indicate how to print the String
     * @return String representation of Tree
     */
    public String toString(int depth, Order order) {
        String result = "";
        String tab = "";

        if(depth != -1) {
            depth++;
            for (int i = 0; i < depth; i++) {
                tab += "\t";
            }
        }
        switch (order) {
            case IN:
                result = getInOrder(depth, result, tab);
                break;
            case POST:
                result = getPostOrder(depth, result, tab);
                break;
            case PRE:
                result = getPreOrder(depth, result, tab);
                break;
            default:
                throw new InvalidParameterException("Order must be PRE, IN or ORDER, found: " + order);
        }
        return result;
    }

    /**
     * Get the string result for InOrder
     * @param depth how far to align the printed elements
     * @param result the string to concatenate the result on
     * @param tab calculate spacing using depth
     * @return Result with added String
     */
    private String getInOrder(int depth, String result, String tab) {
        result = left(depth, result, tab, Order.IN);
        result = current(depth, result, tab);
        result = right(depth, result, tab, Order.IN);
        return result;
    }

    /**
     * Get the string result for PreOrder
     * @param depth how far to align the printed elements
     * @param result the string to concatenate the result on
     * @param tab calculate spacing using depth
     * @return Result with added String
     */
    private String getPreOrder(int depth, String result, String tab) {
        result = left(depth, result, tab, Order.PRE);
        result = current(depth, result, tab);
        result = right(depth, result, tab, Order.PRE);
        return result;
    }

    /**
     * Get the string result for PostOrder
     * @param depth how far to align the printed elements
     * @param result the string to concatenate the result on
     * @param tab calculate spacing using depth
     * @return Result with added String
     */
    private String getPostOrder(int depth, String result, String tab) {
        result = left(depth, result, tab, Order.POST);
        result = current(depth, result, tab);
        result = right(depth, result, tab, Order.POST);
        return result;
    }

    /**
     * Print the current node
     * @param depth how far to align the printed elements
     * @param result the string to concatenate the result on
     * @param tab calculate spacing using depth
     * @return Result with added String
     */
    private String current(int depth, String result, String tab) {
        result += value;
        result += (depth == -1) ? " " : "\n" + tab;
        return result;
    }

    /**
     * Print the left node and the left side
     * @param depth how far to align the printed elements
     * @param result the string to concatenate the result on
     * @param tab calculate spacing using depth
     * @return Result with added String
     */
    private String left(int depth, String result, String tab, Order order) {
        result += (left == null) ? "" : tab + left.toString(depth, order);
        result += (depth == -1) ? " " : "\n" + tab;
        return result;
    }

    /**
     * Print the right node and the right side
     * @param depth how far to align the printed elements
     * @param result the string to concatenate the result on
     * @param tab calculate spacing using depth
     * @return Result with added String
     */
    private String right(int depth, String result, String tab, Order in) {
        result += (right == null) ? "" : tab + right.toString(depth, in);
        result += (depth == -1) ? " " : "\n" + tab;
        return result;
    }
}
