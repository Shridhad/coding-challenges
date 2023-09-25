package dev.shriidhar.leetcode.howsum;

import java.util.ArrayList;
import java.util.List;

public class HowSum {

    /**
     * Brute Force approach to find array of numbers that sum up to the target.

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
}
