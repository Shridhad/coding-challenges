package dev.shriidhar.leetcode.cansum;

import java.util.HashMap;
import java.util.List;

public class CanSum {

    /**
     * Brute Force approach to derive if target sum can be generated from given array of numbers.
     *
     * Time Complexity = O(n ^ m) [m = target sum, n = array length]
     * Space Complexity = O(m)
     * @param target    A target sum to be generated
     * @param numbers   Array of numbers
     * @return true if target sum can be generated from numbers, otherwise false.
     */
    public static boolean bruteForce(long target, List<Long> numbers) {
        if (target == 0) return true;
        if (target < 0) return false;

        for (long number: numbers) {
            long remainder = target - number;
            if (bruteForce(remainder, numbers)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Memoization approach to derive if target sum can be generated from given array of numbers.
     *
     * Time Complexity = O(n * m) [m = target sum, n = array length]
     * Space Complexity = O(m)
     * @param target    A target sum to be generated
     * @param numbers   Array of numbers
     * @return true if target sum can be generated from numbers, otherwise false.
     */
    public static boolean memoization(long target, List<Long> numbers) {
        HashMap<Long, Boolean> memo = new HashMap<>();
        return recurse(memo, target, numbers);
    }

    private static boolean recurse(HashMap<Long, Boolean> memo, long target, List<Long> numbers) {
        if (target == 0) return true;
        if (target < 0) return false;
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        for (long number: numbers) {
            long remainder = target - number;
            boolean canSum = recurse(memo, remainder, numbers);
            memo.put(remainder, canSum);
            if (canSum) {
                return true;
            }
        }

        return false;
    }
}
