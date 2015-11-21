package nl.HAN.ASD.APP.dataStructures;

import com.google.gag.annotation.disclaimer.WrittenWhile;

import java.util.*;

/**
 * Created by Pim van Gurp, 9/9/2015.
 */
@SuppressWarnings({"NullableProblems", "ConstantConditions"})
public class MyArrayList<T> implements List<T>, Iterable<T> {
    /**
     * Amount of elements in array. Can differ from array.length
     */
    private int length;

    /**
     * Internal array for storing elements
     */
    private T[] array;

    /**
     * Constructor for MyArrayList where attributes are initialized
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (T[]) new Object[3];
        length = 0;
    }

    /**
     * Private iterator class
     * used to iterate over all all array elements.
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
            return current < array.length;
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            return array.get(current++);
        }
    }

    /**
     * Amount of elements in array.
     * Can differ from array.length
     * @return amount of elements in array as int
     */
    @Override
    public int size() {
        return length;
    }

    /**
     * Check if array contains no elements
     * @return 1 array has no elements
     *         0 array has elements
     */
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Get an element at a custom position
     * using an index
     * @param index position of element to get
     * @return element at index position
     */
    @Override
    public T get(int index) {
        if(index > size() || index < 0) throw new IndexOutOfBoundsException();
        //noinspection unchecked
        return array[index];
    }

    /**
     * Set a position of the array with a new element
     * @param index position in array
     * @param element value to set
     * @return new element that got added
     */
    @Override
    public T set(int index, T element) {
        if(index > size() || index < 0) throw new IndexOutOfBoundsException();
        array[index] = element;
        return element;
    }

    /**
     * Add a new element to array
     * @param index position in array
     * @param element new value
     */
    @Override
    public void add(int index, T element) {
        if(length == array.length) increaseArraySize();
        array[index] = element;
        length++;
    }

    /**
     * Add a new element to the array at the end
     * of the array
     * @param element new value to add at the end
     * @return if element is added
     */
    @Override
    public boolean add(T element) {
        if(length == array.length) increaseArraySize();
        array[length++] = element;
        return true;
    }

    /**
     * Internal function to increase the array if
     * there are no more free positions
     */
    @SuppressWarnings("unchecked")
    private void increaseArraySize() {
        T[] old = array;
        array = (T[]) new Object[old.length*2+1];
        System.arraycopy(old, 0, array, 0, old.length);
    }

    /**
     * Return the attribute array
     * @return array containing all the arrayList values
     */
    @Override
    public Object[] toArray() {
        return array;
    }

    /**
     * Used because the toArray below can't be changed
     * @param i random
     * @return array representation
     */
    @SuppressWarnings("UnusedParameters")
    @WrittenWhile("Way too late")
    public T[] toArray(int i) {
        //noinspection unchecked
        return array;
    }

    /**
     * Return the attribute array casted to T
     * @param a I Really don't know
     * @return casted array
     */
    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray(Object[] a) {
        return array;
    }

    /**
     * Remove a custom element using index
     * @param index position to remove
     * @return removed element
     */
    @Override
    public T remove(int index) {
        if(isEmpty()) return null;

        T removed = array[index];
        //noinspection ManualArrayCopy
        for(int i = index+1; i < length; i++) {
            array[i-1] = array[i];
        }
        length--;
        return removed;
    }

    /**
     * Used to reset the array and make it empty.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        array = (T[]) new Object[3];
        length = 0;
    }

    /**
     * Print all array elements as a single String
     * @return string containing all array elements
     */
    @Override
    public String toString() {
        String result = " ";
        for(int i = 0; i < array.length; i ++) {
            if( "".equals( get(i).toString() ) ) continue;
            result += " ["+ get(i) +"],";
        }
        return result.substring(0, result.length()-1);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    /*----------------------------------------------*/
    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }



    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }



    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ListIterator listIterator() {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

}
