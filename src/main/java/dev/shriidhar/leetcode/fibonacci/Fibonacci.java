package dev.shriidhar.leetcode.fibonacci;

public class Fibonacci {

    /**
     * The following recursive implementation is correct and returns correct result, however, for large numbers its pretty slow.
     *
     * For example, if `n` is 50, it takes about 30 seconds for this function to provide the result.
     *
     * @param n number
     * @return  returns the nth number in fibonacci series
     */
    public static long recursive(int n) {
        if (n <= 2) {
            return 1;
        }
        return recursive(n-1) + recursive(n-2);
    }
}
