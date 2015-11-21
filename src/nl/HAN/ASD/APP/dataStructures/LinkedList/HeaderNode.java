package nl.HAN.ASD.APP.dataStructures.LinkedList;

/**
 * Created by Pim van Gurp, 9/9/2015.
 */
public class HeaderNode<T> {
    /**
     * The first node in the chain of linked nodes
     */
    private ListNode<T> node;

    /**
     * Simple constructor for headerNode
     * only used to fill node attribute
     */
    public HeaderNode() {
        node = new ListNode<>();
    }

    /**
     * Method for adding a new node at the beginning of the node chain
     * @param element value to add in the new node
     */
    public ListNode<T> add(T element) {
        ListNode<T> newNode = new ListNode<>(node, null, element);
        node.setPrev(newNode);
        node = newNode;
        return node;
    }

    /**
     * Method for removing the first node in the chain by replacing it
     * with the next in line.
     */
    public ListNode<T> remove() {
        ListNode<T> removed = node;
        node = node.next();
        node.setPrev(null);
        return removed;
    }

    /**
     * Get an element out the chain using an index
     * @param index position of element
     * @return the element on index
     */
    public ListNode<T> get(int index){
        ListNode<T> current = node;
        while(index-- > 0) {
            current = (current == null) ? null : current.next();
        }
        return current;
    }

    /**
     * Insert a new node in a custom place in the chain
     * using an index.
     * @param index place to put new node
     * @param element value of new node
     */
    public void insert(int index, T element) {
        ListNode<T> pos = get(index);
        ListNode<T> newNode = new ListNode<>( pos, pos.prev(), element);
        pos.prev().setNext(newNode);
        pos.next().setPrev(newNode);
    }

    /**
     * Remove a node at a custom position using an index
     * @param index position of element to remove
     */
    public ListNode<T> delete(int index) {
        ListNode<T> deleted = get(index);
        deleted.prev().setNext(deleted.next());
        deleted.next().setPrev(deleted.prev());
        return deleted;
    }
}
