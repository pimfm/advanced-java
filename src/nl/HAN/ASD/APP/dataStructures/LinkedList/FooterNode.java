package nl.HAN.ASD.APP.dataStructures.LinkedList;

/**
 * Created by Pim van Gurp, 9/26/2015.
 */
public class FooterNode<T> {

    /**
     * Last node in the LinkedList
     */
    private ListNode<T> node;

    /**
     * Constructor for a new FooterNode.
     * This is the last node in a
     * DoublyLinkedList
     */
    public FooterNode() {
        node = new ListNode<>();
    }

    /**
     * Remove the element closest to footer
     * @return the removed element
     */
    public ListNode<T> remove() {
        ListNode<T> removed = node;
        if(node.prev() != null) {
            node.prev().setNext(null);
            node = node.prev();
        } else {
            node = null;
        }
        return removed;
    }

    /**
     * Add an element at the end of the linked list
     * @param element value of new node
     * @return the added node
     */
    public ListNode<T> add(T element) {
        ListNode<T> newNode = new ListNode<>( element );
        node.setNext(newNode);
        newNode.setPrev(node);
        node = newNode;
        return newNode;
    }

    /**
     * Set a reference to the last node in the chain.
     * Only happens on first add
     * @param node last node in chain
     */
    public void set(ListNode<T> node) {
        this.node = node;
    }


    /**
     * Reset the reference to the last node in the chain.
     * Only happens when list is empty after removing
     */
    public void reset() {
        this.node = null;
    }

    /**
     * Get an element out the chain using an index
     * @param index position of element
     * @return the element on index
     */
    public ListNode<T> get(int index){
        ListNode<T> current = node;

        while(index-- > 0) {
            current = (current == null) ? null : current.prev();
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
        pos.setPrev(newNode);
    }

    /**
     * Remove a node at a custom position using an index
     * @param index position of element to remove
     */
    public ListNode<T> delete(int index) {
        ListNode<T> deleted = get(index);

        if(deleted.prev() != null)
            deleted.prev().setNext(deleted.next());

        if(deleted.next() != null)
            deleted.next().setPrev(deleted.prev());

        return deleted;
    }
}
