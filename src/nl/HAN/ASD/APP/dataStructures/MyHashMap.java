package nl.HAN.ASD.APP.dataStructures;

import com.google.gag.annotation.disclaimer.WrittenWhile;
import nl.HAN.ASD.APP.dataStructures.LinkedList.MyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Pim van Gurp, 9/15/2015.
 */
public class MyHashMap<T> implements Iterable<T>{
    /**
     * Internally used list for storing hashed values
     */
    private MyArrayList<MyLinkedList<Tuple<T>>> hashed;

    /**
     * A set of all the keys that are stored
     */
    private MyArrayList<String> keys;

    /**
     * A prime number used to set the length of the internal hashMap.
     * The length must be prime for quadratic probing
     */
    private final int PRIME;

    /**
     * Constructor for new hashMap.
     * A new internal hashMap is made with a new list
     * on every position
     */
    public MyHashMap() {
        PRIME = 31;
        hashed = new MyArrayList<>();
        keys = new MyArrayList<>();
        reset();
    }

    /**
     * Private iterator class
     * used to iterate over all all linked list elements.
     * Works with foreach loops.
     */
    private class MyIterator implements Iterator<T> {
        private MyHashMap<T> hashMap;
        private MyArrayList<String> keys;
        private int current;

        MyIterator(MyHashMap<T> hashMap) {
            this.hashMap = hashMap;
            this.keys = hashMap.keys;
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < keys.size();
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            return hashMap.lookup( keys.get(current++) );
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
     * Clear the hashMap and place an empty list on every position
     */
    private void reset() {
        hashed.clear();

        for(int i = 0; i < PRIME; i++) {
            hashed.add( new MyLinkedList<>() );
        }
    }

    /**
     * Put a new hashed value in the hashMap.
     * @param key a String identifier for the value
     * @param value a value corresponding with the String key
     */
    public void put(String key, T value) {
        int i = hash(key);
        MyLinkedList<Tuple<T>> list = hashed.get(i);
        list.add(new Tuple<>(key, value));
        keys.add(key);
        hashed.set(i, list);
    }

    /**
     * Return all the keys that are internally used
     * for storing the hashed values
     * @return set of keys
     */
    public MyArrayList<String> keySet() {
        return keys;
    }

    /**
     * Find a value in the hashMap that meets the key
     * @param key used to find the value
     * @return value that corresponds the key
     */
    public T lookup(String key) {
        MyLinkedList<Tuple<T>> list = hashed.get( hash(key) );
        if(list == null) return null;
        int i = 0;
        Tuple<T> toCheck = list.get(i).getValue();
        if(toCheck == null) return null;
        while(!toCheck.key.equals(key)) {
            toCheck = list.get(++i).getValue();
        }
        return toCheck.value;
    }

    /**
     * Return all hashed values as an hashMap
     * @return hashed values in hashMap
     */
    @WrittenWhile("Caffeine levels dangerously low.")
    public T[] toArray() {
        MyArrayList<T> result = new MyArrayList<>();

        for (MyLinkedList<Tuple<T>> list : hashed) {
            int j = 0;
            while (list.get(j) != null) {
                result.add(list.get(j).getValue().value);
                j++;
            }
        }

        return result.toArray(1);
    }

    /**
     * Check if the hashMap has no elements
     * @return 1 hashMap is empty
     *         0 hashMap has at least 1 element
     */
    public boolean isEmpty() {
        return hashed.isEmpty();
    }

    /**
     * Get amount of elements in hashMap
     * @return amount of elements
     */
    public int size() {
        return hashed.size();
    }

    /**
     * Used to find an index that matches the key
     * @param key key to generate index with
     * @return index that the key produces
     */
    private int hash(String key) {
        char[] characters = key.toCharArray();
        int result = 0;
        for(char c : characters) {
            result += (int) c;
        }
        return result % PRIME;
    }

    /**
     * String representation of the hashMap
     * @return String representation
     */
    @Override
    public String toString() {
        return hashed.toString();
    }
}

