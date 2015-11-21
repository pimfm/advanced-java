package nl.HAN.ASD.APP.generics;

/**
 * Created by Pim van Gurp, 9/8/2015.
 */
public class GenericsMain {
    public static void main(String[] args) {
        MemoryCell<Integer> a = new MemoryCell<>();
        a.write(23);
        MemoryCell<Integer> b = new MemoryCell<>();
        b.write(22);
        System.out.println(a.compareTo(b));
        System.out.println(a.read() + b.read());
    }
}
