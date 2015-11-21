package nl.HAN.ASD.APP.dataStructures.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Pim van Gurp, 9/26/2015.
 */
@SuppressWarnings("unchecked")
public class MyDoublyLinkedList<T> extends MyLinkedList<T> {
    /**
     * Last node in the chain
     */
    private FooterNode<T> footer;

    /**
     * Length of linkedList
     */
    private int length;

    /**
     * Simple constructor.
     */
    public MyDoublyLinkedList() {
        reset();
    }

    /**
     * Private iterator class
     * used to iterate over all all linked list elements.
     * Works with foreach loops.
     */
    private class MyIterator implements Iterator<T> {
        private MyDoublyLinkedList<T> list;
        private int current;

        MyIterator(MyDoublyLinkedList<T> list) {
            this.list = list;
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < list.length;
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            return list.get(current++).getValue();
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator( this );
    }

    /**
     * Insert a new node at a custom position using index
     * @param index position to add new ListNode
     * @param element value of node to add
     */
    @Override
    public void insert(int index, T element) {
        if(smallIndex( index )) {
            super.insert(index, element);
        } else {
            footer.insert( backwards(index), element);
        }
        length++;
    }

    /**
     * Remove a node at a custom position in Chain
     * @param index position to remove node
     */
    @Override
    public void delete(int index) {
        if(smallIndex( index )) {
            super.delete(index);
        } else {
            footer.delete( backwards(index) );
        }
        length--;
    }

    /**
     * Add a node at the beginning of the chain
     * @param element new element to add in a node wrap
     */
    @Override
    public ListNode<T> add(T element) {
        ListNode<T> newNode = super.add(element);
        if(isEmpty()) {
            footer.set(newNode);
        }
        length++;
        return newNode;
    }

    /**
     * Get a node from a custom position using index
     * @param i position to get ListNode
     * @return node at position index
     */
    @Override
    public ListNode<T> get( int i ) {
        return ( smallIndex(i) )
                ? super.get(i)
                : footer.get( backwards(i) );
    }

    /**
     * Add a node at the beginning of the chain
     */
    @Override
    public ListNode<T> remove() {
        ListNode<T> removed = super.remove();
        if(removed != null) length--;

        if(isEmpty()) {
            footer.reset();
        }
        return removed;
    }

    /**
     * Remove the element at the end of the linked list
     * using the footer node
     * @return removed element
     */
    public ListNode<T> removeLast() {
        if(!isEmpty()) {
            ListNode<T> removed = footer.remove();
            length--;
            return removed;
        } else {
            return null;
        }
    }

    /**
     * Add an element to the end of list
     * @param element new element
     * @return added element
     */
    public ListNode<T> addLast(T element) {
        if(isEmpty()) {
            return add(element);
        } else {
            length++;
            return footer.add( element );
        }
    }

    /**
     * Get number of nodes in linked list
     * @return number of node
     */
    @Override
    public int size() {
        return length;
    }

    /**
     * Check if the linked list is empty
     * @return 1 list is empty
     *         0 list has nodes
     */
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    public void reset() {
        super.reset();
        footer = new FooterNode<>();
        length = 0;
    }

    /**
     * Which index to use when sea3rching from
     * footer.
     * @param index index to transform to backwards index
     * @return backwards index
     */
    private int backwards(int index) {
        return size() - index - 1;
    }

    /**
     * Check if index is small enough to start at the header
     * @param i index to Tokenizer
     * @return 1 index small enough
     *         0 index too big
     */
    private boolean smallIndex(int i) {
        return i <= (size() / 2) || i < 5;
    }

}
