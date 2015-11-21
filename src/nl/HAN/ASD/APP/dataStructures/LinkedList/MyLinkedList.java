package nl.HAN.ASD.APP.dataStructures.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Pim van Gurp, 9/9/2015.
 */
public class MyLinkedList<T> implements Iterable<T>{
    /**
     * Main beginning node without value used for administration
     */
    private HeaderNode<T> header;

    /**
     * Amount of elements in linked list
     */
    private int length;

    /**
     * LinkedList constructor. Used for initializing
     * header
     */
    public MyLinkedList() {
        reset();
    }


    /**
     * Private iterator class
     * used to iterate over all all linked list elements.
     * Works with foreach loops.
     */
    private class MyIterator implements Iterator<T> {
        private MyLinkedList<T> list;
        private int current;

        MyIterator(MyLinkedList<T> list) {
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
     * Add a node at the beginning of the chain
     * @param element new element to add in a node wrap
     */
    public ListNode<T> add(T element) {
        ListNode<T> newNode = header.add(element);
        length++;
        return newNode;
    }

    /**
     * Get amount of elements in linked list
     * @return integer representing amount of elements in linked list
     */
    public int size() {
        return length;
    }

    /**
     * Check if list contains nodes
     * @return 0 list contains nodes
     *         1 list is empty
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Remove the node at the beginning of the chain
     */
    public ListNode<T> remove() {
        if(length == 0) return null;
        length--;
        return header.remove();
    }

    /**
     * Insert a new node at a custom position using index
     * @param index position to add new ListNode
     * @param element value of node to add
     */
    public void insert(int index, T element) {
        header.insert(index, element);
    }

    /**
     * Remove a node at a custom position in Chain
     * @param index position to remove node
     */
    public void delete(int index) {
        length--;
        header.delete(index);
    }

    public void reset() {
        header = new HeaderNode<>();
        length = 0;
    }

    /**
     * Get a node from a custom position using index
     * @param index position to get ListNode
     * @return node at position index
     */
    public ListNode<T> get(int index) {
        return header.get(index);
    }

    /**
     * Array representation of linkedList
     * @return list representation of linkedList
     */
    @SuppressWarnings("unchecked")
    public T[] toArray(Object[] a) {
        int i = 0;
        T[] result = (a.length < size())
                ? (T[]) new Object[size()]
                : (T[]) a;
        while(i < size()) {
            result[i] = get(i).getValue();
            i++;
        }
        return result;
    }

    /**
     * Return all elements in list as single String
     * @return string concatenation of list elements
     */
    @Override
    public String toString() {
        String result = "";

        for(int i = size()-1; i >= 0; i--) {
            if(get(i) == null) continue;
            result += "\n";
            result += get(i);
        }
        return (result.equals("")) ? "" : result.substring(0, result.length()-1);
    }
}
