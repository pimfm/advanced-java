package nl.HAN.ASD.APP.recursion;
import processing.core.PApplet;

/**
 * Created by Pim, 9/2/2015.
 */
public class RecursionMain {
    public static void main(String[] args) {
        Recursive recursive = new Recursive();
        NonRecursive nonRecursive = new NonRecursive();
        System.out.println( recursive.factorial(5) );
        System.out.println( nonRecursive.factorial(5) );
        System.out.println( recursive.sum(5) );
        System.out.println( nonRecursive.sum(5) );
        System.out.println( recursive.binaryCount(15) );
        System.out.println( recursive.reverse("Recursive is awesome!") );
        System.out.println( recursive.reverseWithBuffer("Recursive is amazing!") );
        System.out.println( recursive.fibonacci(0) );
        System.out.println( recursive.betterFibonacci(0) );
        System.out.println( recursive.sumDigits(345) );
        PApplet.main(new String[] {"nl.HAN.ASD.APP.recursion.Tree"});
    }
}
