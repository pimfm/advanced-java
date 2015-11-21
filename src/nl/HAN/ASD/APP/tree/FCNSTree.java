package nl.HAN.ASD.APP.tree;

/**
 * Created by Pim van Gurp, 9/18/2015.
 */
@SuppressWarnings("unchecked")
public class FCNSTree<T> {
    /**
     * Stored contents in current node
     */
    private T value;

    /**
     * A reference to the first child
     * of the current node
     */
    private FCNSTree<T> firstChild;

    /**
     * A reference to the next sibling
     * of the current node
     */
    private FCNSTree<T> nextSibling;

    /**
     * Empty constructor
     */
    public FCNSTree() {}

    /**
     * Constructor that sets a value when
     * making a new object
     * @param value contents to set
     */
    public FCNSTree(T value) {
        this.value = value;
    }

    /**
     * Add a new sibling to the chain of siblings
     * of current node
     * @param value contents of the added sibling
     */
    public void addSibling(T value) {
        if(nextSibling == null)
            nextSibling = new FCNSTree<>( value );
        else
            nextSibling.addSibling( value );
    }

    /**
     * Add a new child to the chain of children
     * that this node has
     * @param value contents of the added child
     */
    public void addChild(T value) {
        if(firstChild == null)
            firstChild = new FCNSTree<>( value );
        else
            firstChild.addChild( value );
    }

    /**
     * Get the contents in this node
     * @return value
     */
    public T getValue() {
        return value;
    }

    /**
     * Give a string representation of the FCNSTree
     * @return String representation
     */
    @Override
    public String toString() {
        String result = "";

        if(firstChild != null)
            result += firstChild.toString();

        if(value != null)
            result += "( " + value + " )";

        if(nextSibling != null)
            result += nextSibling.toString();

        return result;
    }
}
