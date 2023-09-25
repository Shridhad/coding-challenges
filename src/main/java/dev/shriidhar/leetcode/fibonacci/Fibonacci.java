package dev.shriidhar.leetcode.fibonacci;

import java.util.HashMap;

public class Fibonacci {

    /**
     * The following recursive implementation is correct and returns correct result, however, for large numbers it's pretty slow.
     *
     * For example, if `n` is 50, it takes about 30 seconds for this function to provide the result.
     *
     * Time complexity: O(2^n)
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

    /**
     * Memoization is one of the overarching strategy to solve dynamic programming problem.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param number number
     * @return returns the nth number in fibonacci series
     */
    public static long memoization(int number) {
        HashMap<Integer, Long> memo = new HashMap<>();
        return recursive(memo, number);
    }

    private static long recursive(HashMap<Integer, Long> memo, int number) {
        if (number <= 2) {
            return 1;
        }
        if (memo.containsKey(number)) {
            return memo.get(number);
        }
        memo.put(number, recursive(memo,number - 1) + recursive(memo,number - 2));
        return memo.get(number);
    }
}
