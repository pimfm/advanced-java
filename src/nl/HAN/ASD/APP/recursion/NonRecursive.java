package nl.HAN.ASD.APP.recursion;

/**
 * Created by Pim van Gurp, 9/25/2015.
 */
public class NonRecursive {
    /**
     * Return the product of N and
     * every number that is less than N
     * @param n number to do factorial on
     * @return factorial product of N
     */
    public long factorial(int n) {
        if(n <= 1) return 1;
        long result = n;

        while(n >= 2) {
            result *= --n;
        }
        return result;
    }

    /**
     * Return the sum of N and every
     * number that is less than N
     * @param n number to use sum on
     * @return sum of N and every number lower than N
     */
    public long sum(int n) {
        if(n <= 1) return n;
        long sum = n;

        while(n > 0) {
            sum += --n;
        }
        return sum;
    }
}
