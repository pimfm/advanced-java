package nl.HAN.ASD.APP.dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Pim van Gurp, 9/10/2015.
 */
public class MyQueue<T> implements Iterable<T> {
    /**
     * Internal array used to enqueue and dequeue elements
     */
    private MyArrayList<T> array;

    /**
     * Simple constructor for Queue.
     */
    public MyQueue() {
        array = new MyArrayList<>();
    }

    /**
     * Private iterator class
     * used to iterate over all all linked array elements.
     * Works with foreach loops.
     */
    private class MyIterator implements Iterator<T> {
        private MyArrayList<T> array;
        private int current;

        MyIterator(MyArrayList<T> array) {
            this.array = array;
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < array.size();
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            return array.get(current++);
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator( array );
    }

    /**
     * Add a new element in the queue at
     * the end of the line
     * @param element element to add
     */
    public void enqueue(T element) {
        array.add(element);
    }

    /**
     * Receive the first element in line
     * in the queue
     * @return first element in line
     */
    public T dequeue() {
        return array.remove(0);
    }

    /**
     * Return the first element in line without
     * removing it from the queue
     * @return the first element in the queue
     */
    public T peek() {
        return array.get(0);
    }

    /**
     * Return array representation of Queue
     * @return array with queued items
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) array.toArray();
    }

    /**
     * Get amount of elements stored
     * in internal array
     * @return amount of elements stored
     */
    public int size() {
        return array.size();
    }

    /**
     * Check if the queue has elements
     * @return 1 queue has no elements
     *         0 queue still has elements
     */
    public boolean isEmpty() {
        return size() <= 0;
    }

    /**
     * String representation of all elements in queue
     * @return string with all array values
     */
    @Override
    public String toString() {
        return array.toString();
    }
}
