package nl.HAN.ASD.APP.dataStructures;

import nl.HAN.ASD.APP.dataStructures.LinkedList.MyDoublyLinkedList;
import nl.HAN.ASD.APP.dataStructures.LinkedList.MyLinkedList;

/**
 * Created by Pim van Gurp, 9/9/2015.
 */
public class DataStructuresMain {
    public static void main(String[] args) {
//        MyHashMap<Integer> hashMap = new MyHashMap<>();
//        hashMap.put("Apeldoorn", 17);
//        hashMap.put("Arnhem", 28);
//        hashMap.put("Konijn", 88);
//        hashMap.put("A", 99);
//        hashMap.put("AB", 99);
//        hashMap.put("ABC", 99);
//        hashMap.put("ABCD", 99);
//        hashMap.put("ABCDE", 99);
//        hashMap.put("ABCDEF", 99);
//        hashMap.put("ABCDEFG", 99);
//        hashMap.put("ABCDEFGH", 99);
//        System.out.println(hashMap.toString());
//        System.out.println(hashMap.lookup("Apeldoorn"));
//
//        MyArrayList<Integer> array = new MyArrayList<>();
//        array.add(58);
//        array.add(89);
//        array.add(43);
//        for(Integer i : array) {
//            System.out.println("Getal in array: " + i);
//        }
        MyLinkedList<Integer> single = new MyLinkedList<>();
        single.add(12);
        single.add(16);
        single.add(18);
        single.add(99);
        single.add(123);
        single.add(20);
        single.add(10);
        System.out.println(single.toString());

        MyDoublyLinkedList<Integer> doubly = new MyDoublyLinkedList<>();
        doubly.add(12);
        doubly.add(16);
        doubly.add(18);
        doubly.add(99);
        doubly.add(123);
        doubly.add(20);
        doubly.add(10);
        doubly.add(10);
        System.out.println(doubly.toString());
    }
}
