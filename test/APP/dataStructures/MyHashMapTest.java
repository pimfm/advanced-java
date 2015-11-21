package APP.dataStructures;

import nl.HAN.ASD.APP.dataStructures.MyHashMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pim van Gurp, 9/17/2015.
 */
public class MyHashMapTest {
    private MyHashMap<Integer> hashMap;

    @Before
    public void setUp() {
        hashMap = new MyHashMap<>();
        hashMap.put("Pim", 20);
        hashMap.put("Christian", 20);
        hashMap.put("Iris", 17);
        hashMap.put("Willie", 50);
        hashMap.put("Petra", 46);
    }

    @Test
    public void testPut() {
        hashMap.put("Pim", 19);
        hashMap.put("Pieter", 18);
        assertEquals(19, (int) hashMap.lookup("Pim"));
        assertEquals(18, (int) hashMap.lookup("Pieter"));
    }

    @Test
    public void testLookup() {
        assertEquals(20, (int) hashMap.lookup("Pim"));
        assertEquals(20, (int) hashMap.lookup("Christian"));
    }
}