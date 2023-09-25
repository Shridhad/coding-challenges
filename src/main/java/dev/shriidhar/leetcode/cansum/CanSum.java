package dev.shriidhar.leetcode.cansum;

import java.util.List;

public class CanSum {

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
}
