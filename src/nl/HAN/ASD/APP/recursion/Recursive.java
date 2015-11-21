package nl.HAN.ASD.APP.recursion;

import java.security.InvalidParameterException;

/**
 * Created by Pim, 9/2/2015.
 */

public class Recursive {
    /**
     * Get the factorial value for n
     * @param n number to use factorial on
     * @return factorial product of n
     */
    public long factorial(int n) {
        return (n <= 1) ? 1 : factorial(n-1) * n;
    }

    /**
     * Return the sum of the current number
     * and every number lower
     * @param n number to perform sum on
     * @return sum representation of n
     */
    public long sum(int n) {
        return (n <= 1) ? n : sum(n-1) + n;
    }

    /**
     * Return the fibonacci number at the N place in the sequence.
     * e.g. 5 -> 3, 6 -> 5, 6 -> 8
     * @param n place in fibonacci sequence
     * @return the fibonacci number that is at place N
     * @throws InvalidParameterException for N < 0
     */
    public long fibonacci(int n) {
        if(n < 0) throw new InvalidParameterException("N must be greater than 0, found" + n);
        if(n == 1 || n == 0) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    /**
     * The same user experience as the other fibonacci method,
     * but is more efficient.
     * @param n position in fibonacci sequence
     * @return fibonacci value on position N
     */
    public long betterFibonacci(int n) {
        if(n < 0) throw new InvalidParameterException("N must be greater than 0, found: " + n);
        return betterFibonacci(n, 1, 0);
    }

    /**
     * used internally by @Code(betterFibonacci)
     * @param n position in fibonacci sequence to get value from
     * @param value a buffer containing current fibonacci value
     * @param prev a buffer containing the previous fibonacci value
     * @return the fibonacci value in the sequence on position N
     */
    private long betterFibonacci(int n, int value, int prev) {
        if(n == 0) return prev;
        if(n == 1) return value;
        return betterFibonacci(n-1, value + prev, value);
    }

    /**
     * Give a sum of all the single digits
     * @param n positive integer value with 1 or more digits
     * @return sum of all digits in N
     */
    public int sumDigits(int n) {
        if(n < 10) return n;
        return sumDigits( n / 10 ) + n % 10;
    }

    /**
     * Get the number of 1s in the binary
     * representation of n
     * @param n number to Tokenizer amount of 1s
     * @return number of 1s in n
     */
    public int binaryCount(int n) {
        if(n <= 1) return n;
        return n % 2 + binaryCount(n / 2);
    }

    /**
     * Return a string in reverse order
     * Example => elpmaxE
     * @param str string to reverse
     * @return reversed string
     */
    public String reverse(String str) {
        if(str.length() == 1) return str;
        String lastChar = str.substring(str.length()-1, str.length());
        String remainingStr = str.substring(0, str.length() -1);
        return lastChar + reverse(remainingStr);
    }

    public String reverseWithBuffer(String str) {
        StringBuffer buffer = new StringBuffer(str);
        reverse( buffer );
        return buffer.toString();
    }

    private void reverse(StringBuffer buffer) {
        buffer.reverse();
    }
}