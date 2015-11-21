package nl.HAN.ASD.APP.dataStructures.LinkedList;

/**
 * Created by Pim van Gurp, 9/9/2015.
 */
public class ListNode<T> {
    /**
     * The next and previous node in the linked ListNode chain
     */
    private ListNode<T> next;
    private ListNode<T> prev;

    /**
     * Value of element in the current node
     */
    private T value;

    /**
     * Constructor with parameters, used to
     * initialize next and value
     * @param next the next node in the ListNode chain
     * @param prev the previous node in the ListNode chain
     * @param value value of this current node
     */
    public ListNode(ListNode<T> next, ListNode<T> prev, T value) {
        this.next = next;
        this.prev = prev;
        this.value = value;
    }

    /**
     * Simple constructor used the first time, when no
     * nodes are added yet
     */
    public ListNode() {}

    /**
     * Constructor for new node
     * with only a new value
     * @param value value of node
     */
    public ListNode(T value) {
        this.value = value;
    }

    /**
     * Receive the next node in the chain
     * @return next node
     */
    public ListNode<T> next() {
        return next;
    }

    /**
     * Receive the previous node in the chain
     * @return previous node
     */
    public ListNode<T> prev() {
        return prev;
    }

    /**
     * Used to change the next node to a different node
     * @param next new next node
     */
    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    /**
     * Used to change the previous node to a different node
     * @param prev new previous node
     */
    public void setPrev(ListNode<T> prev) {
        this.prev = prev;
    }


    /**
     * Read value from current node
     * @return value of current node
     */
    public T getValue() {
        return value;
    }

    /**
     * String representation of single node in linked list
     * @return String concatenation of node values
     */
    @Override
    public String toString() {
        String result = "(";

        result += (prev() != null)
                ? prev().getValue() + " <-- "
                : "       ";

        result += "(" + value + ")";

        result += (next() != null)
                ? " --> " + next().getValue() +""
                : "       ";

        result += ")";
        return result;
    }
}
