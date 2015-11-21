package nl.HAN.ASD.APP.bigO;

/**
 * Created by Pim, 9/1/2015.
 */
public class BigOMain {
    public static void main(String[] args) {
        System.out.println("--------------------------");
        int N_I = 3;
        int D = 1000;
        int n = 10;
        long start_time, end_time, difference;
        for(int i = 0; i < N_I; i++) {
            start_time = System.nanoTime();
            fragment1(n);
            end_time = System.nanoTime();
            difference = (end_time - start_time) / D;
            System.out.println("Fragment 1: difference(" + n + "): " + difference + " ms");
            n *= 10;
        }
        System.out.println("--------------------------");
        n = 10;
        for(int i = 0; i < N_I; i++) {
            start_time = System.nanoTime();
            fragment2(n);
            end_time = System.nanoTime();
            difference = (end_time - start_time) / D;
            System.out.println("Fragment 2: difference(" + n + "): " + difference + " ms");
            n *= 10;
        }
        System.out.println("--------------------------");
        n = 10;
        for(int i = 0; i < N_I; i++) {
            start_time = System.nanoTime();
            fragment3(n);
            end_time = System.nanoTime();
            difference = (end_time - start_time) / D;
            System.out.println("Fragment 3: difference(" + n + "): " + difference + " ms");
            n *= 10;
        }
        System.out.println("--------------------------");
        n = 10;
        for(int i = 0; i < N_I; i++) {
            start_time = System.nanoTime();
            fragment4(n);
            end_time = System.nanoTime();
            difference = (end_time - start_time) / D;
            System.out.println("Fragment 4: difference(" + n + "): " + difference + " ms");
            n *= 10;
        }
        System.out.println("--------------------------");
        n = 10;
        for(int i = 0; i < N_I; i++) {
            start_time = System.nanoTime();
            fragment5(n);
            end_time = System.nanoTime();
            difference = (end_time - start_time) / D;
            System.out.println("Fragment 5: difference(" + n + "): " + difference + " ms");
            n *= 10;
        }
        System.out.println("--------------------------");
        n = 10;
        for(int i = 0; i < N_I; i++) {
            start_time = System.nanoTime();
            fragment6(n);
            end_time = System.nanoTime();
            difference = (end_time - start_time) / D;
            System.out.println("Fragment 6: difference(" + n + "): " + difference + " ms");
            n *= 10;
        }
        System.out.println("--------------------------");
        n = 10;
        for(int i = 0; i < N_I; i++) {
            start_time = System.nanoTime();
            fragment7(n);
            end_time = System.nanoTime();
            difference = (end_time - start_time) / D;
            System.out.println("Fragment 7: difference(" + n + "): " + difference + " ms");
            n *= 10;
        }
        System.out.println("--------------------------");
        n = 10;
        for(int i = 0; i < N_I; i++) {
            start_time = System.nanoTime();
            fragment8(n);
            end_time = System.nanoTime();
            difference = (end_time - start_time) / D;
            System.out.println("Fragment 8: difference(" + n + "): " + difference + " ms");
            n *= 10;
        }
    }


    public static int fragment1(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum++;
        }
        return sum;
    }

    public static int fragment2(int n) {
        int sum = 0;
        for (int i = 0; i < n; i += 2) {
            sum++;
        }
        return sum;
    }

    public static int fragment3(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum++;
            }
        }
        return sum;
    }

    public static int fragment4(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum++;
            for (int j = 0; j < n; j++) {
                sum++;
            }
        }
        return sum;
    }

    public static int fragment5(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * n; j++) {
                sum++;
            }
        }
        return sum;
    }

    public static int fragment6(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        return sum;
    }

    public static int fragment7(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * n; j++) {
                for (int k = 0; k < j; k++) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static int fragment8(int n) {
        int sum = 0;
        for (int i = 1; i < n; i = i * 2) {
            sum++;
        }
        return sum;
    }
}
