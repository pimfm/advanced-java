package nl.HAN.ASD.APP.tree;

import java.security.InvalidParameterException;

/**
 * Created by Pim van Gurp, 9/21/2015.
 */
public class BSTree<T extends Comparable<? super T>, E> {
    /**
     * Key of the object stored in the current node
     */
    private T key;

    /**
     * Value of the object stored in the current node
     */
    private E value;

    /**
     * Tree connected to the left
     */
    private BSTree<T, E> left;

    /**
     * Tree connected to the right
     */
    private BSTree<T, E> right;

    /**
     * Sum of all the subtrees underneath the current node
     */
    private int subTreeValue;

    /**
     * Empty constructor
     */
    public BSTree() {}

    /**
     * Constructor that immediately
     * sets the current object stored
     * @param key identifier of object
     * @param value contents of object
     */
    public BSTree(T key, E value) {
        this.key = key;
        this.value = value;
        subTreeValue = 0;
    }

    /**
     * Check if current node has children
     * @return 1 node has no children
     *         0 node has children
     */
    public Boolean isLeaf() { return left == null && right == null; }

    /**
     * Get the contents of the stored object
     * @return contents
     */
    public E getValue() { return value; }

    /**
     * Add a new node to the tree by comparing it
     * to the current node and hanging it left or right
     * @param other node to compare and add
     * @param value content of the new node
     */
    public void add(T other, E value) {
        if(key == null) {
            key = other;
            this.value = value;
        }

        if(key.compareTo( other ) > 0) {
            addLeft( other, value );
        } else if(key.compareTo( other ) < 0) {
            addRight( other, value );
        }
    }

    /**
     * Add the new node to the left of the current node
     * @param other key of node to add
     * @param value content of new node
    */
    public void addLeft(T other, E value) {
        if(left == null) {
            left = new BSTree<>( other, value );
        } else {
            left.add(other, value);
        }
    }

    /**
     * Add the new node to the right of the current node
     * @param other key of node to add
     * @param value content of new node
     */
    public void addRight(T other, E value) {
        if(right == null) {
            right = new BSTree<>( other, value );
        } else {
            right.add(other, value);
        }
    }

    /**
     * find a value in the tree by recursively comparing it
     * @param k key of object that should be in the tree
     * @return null if item not found or value if found
     */
    public E find(T k) {
        if(isLeaf()) return null;
        int factor = k.compareTo(key);
        if(factor == 0) return value;
        return (factor > 0) ? right.find(k) : left.find(k);
    }

    /**
     * Same as find but returns the subtree instead of only the value
     * @param k key of the object to find
     * @return tree with object as root
     */
    public BSTree<T, E> findTree(T k) {
        if(isLeaf()) return null;
        int factor = key.compareTo(k);
        if(factor == 0) return this;
        return (factor < 0) ? right.findTree(k) : left.findTree(k);
    }

    /**
     * Find the maximum value in the current tree
     * @return max value
     */
    public E max() {
        return right == null ? value : right.max();
    }

    /**
     * Same as max but returns a tree
     * @return max subtree in current tree
     */
    public BSTree<T, E> maxTree() {
        return right == null ? this : right.maxTree();
    }

    /**
     * Find minimum value in current tree
     * @return minimum value
     */
    public E min() {
        return left == null ? value : left.min();
    }

    /**
     * Same as min but returns a tree
     * @return minimum tree
     */
    public BSTree<T, E> minTree() {
        return left == null ? this : left.minTree();
    }

    /**
     * Recursively remove a value inside the tree
     * @param k key of the object to remove from the tree
     * @return the removed tree
     */
    public BSTree<T, E> remove(T k) {
        int factor = k.compareTo( key );

        if(isLeaf()) return null;

        if(factor == 0) {
            //0 children
            if(isLeaf())
                return null;

            //2 children
            if(left != null && right != null) {
                BSTree<T, E> max = left.maxTree();
                remove( max.key );
                max.right = right;
                max.left = left;
                return max;
            }

            //1 child
            if(left != null)
                return left;

            if(right != null)
                return right;
        }

        if(factor < 0)
            left = left.remove( k );

        if(factor > 0)
            right = right.remove( k );

        return this;
    }

    /**
     * Calculate the amount of trees underneath the current node
     * and updat this amount
     * @return subTreeValue
     */
    @SuppressWarnings("ConstantConditions")
    private int calculateSubTreeValues() {
        resetSubTreeValues();
        if(isLeaf()) {
            subTreeValue = 0;
            return 1 + subTreeValue;
        }

        if(right != null && left == null) {
            subTreeValue += right.calculateSubTreeValues();
            return 1 + subTreeValue;
        }

        if(left != null && right == null) {
            subTreeValue += left.calculateSubTreeValues();
            return 1 + subTreeValue;
        }

        subTreeValue += right.calculateSubTreeValues() + left.calculateSubTreeValues();
        return 1 + subTreeValue;
    }

    /**
     * Reset the values of subTrees back to Zero.
     */
    private void resetSubTreeValues() {
        subTreeValue = 0;
        if(right != null)
            right.resetSubTreeValues();
        if(left != null)
            left.resetSubTreeValues();
    }

    /**
     * Give the number of leaves hanging in current tree
     * @return number of leaves
     */
    @SuppressWarnings("ConstantConditions")
    public int nLeaves() {
        if(isLeaf())
            return 1;

        if(right == null && left != null)
            return left.nLeaves();

        if(right != null && left == null)
            return right.nLeaves();

        return right.nLeaves() + left.nLeaves();
    }

    /**
     * Give number of node below the current that contain 1 child
     * with a null value
     * @return number of 1 nulls children
     */
    @SuppressWarnings("ConstantConditions")
    public int n1Nulls() {
        if(isLeaf())
            return 0;

        if(right == null && left != null)
            return 1 + left.n1Nulls();

        if(right != null && left == null)
            return 1 + right.n1Nulls();

        return right.n1Nulls() + left.n1Nulls();
    }

    /**
     * Returns the amount of nodes that have 2 children
     * @return nodes with 2 children
     */
    @SuppressWarnings("ConstantConditions")
    public int n2NonNulls() {
        if(isLeaf()) return 0;
        if(right != null && left != null) {
            return 1 + left.n2NonNulls() + right.n2NonNulls();
        }
        else {
            if(left != null)
                return left.n2NonNulls();
            else
                return right.n2NonNulls();
        }
    }

    /**
     * Return a string of the entire tree.
     * used for printing
     * @param depth used for alignment, use -1 for no alignment
     * @param order PRE, POST and IN indicate how to print the String
     * @return String representation of Tree
     */
    public String toString(int depth, Order order) {
        calculateSubTreeValues();
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
        result += key;
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
