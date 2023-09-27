package dev.shriidhar.leetcode.sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HowSum {

    /**
     * Brute Force approach to find array of numbers that add up to the target.

     * Note: We are using `ArrayList` so we can mutate it as we recurse through input array.

     * Time Complexity = O(n ^ m) [m = target sum, n = array length]
     * Space Complexity = O(m)
     *
     * @param target    A target sum to be generated
     * @param numbers   Array of numbers
     * @return list of numbers that sum up to the target number. otherwise null.
     */
    public static List<Long> bruteForce(Long target, List<Long> numbers) {
        if (target == 0) return new ArrayList<>();
        if (target < 0 || numbers.isEmpty()) return null;

        for (long number: numbers) {
            long remainder = target - number;
            List<Long> result = bruteForce(remainder, numbers);
            if (result != null) {
                result.add(number);
                return result;
            }
        }

        return null;
    }

    /**
     * Memoization approach to find array of numbers that add up to the target.

     * Note: We are using `ArrayList` so we can mutate it as we recurse through input array.

     * Time Complexity = O(n * m) [m = target sum, n = array length]
     * Space Complexity = O(m ^ 2)
     *
     * @param target    A target sum to be generated
     * @param numbers   Array of numbers
     * @return list of numbers that sum up to the target number. otherwise null.
     */
    public static List<Long> memoization(Long target, List<Long> numbers) {
        HashMap<Long, List<Long>> memo = new HashMap<>();
        return recurse(memo, target, numbers);
    }

    private static List<Long> recurse(HashMap<Long, List<Long>> memo, Long target, List<Long> numbers) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0 || numbers.isEmpty()) return null;

        for (long number: numbers) {
            long remainder = target - number;
            List<Long> result = recurse(memo, remainder, numbers);
            if (result != null) {
                result.add(number);
                memo.put(target, result);
                return result;
            }
        }
        memo.put(target, null);
        return null;
    }
}
