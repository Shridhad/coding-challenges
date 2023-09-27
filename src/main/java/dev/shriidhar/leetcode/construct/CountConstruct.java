package dev.shriidhar.leetcode.construct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountConstruct {

    /**
     * Brute Force approach to count number ways the target string can be constructed from given dictionary of words
     *
     * Time Complexity = O(m * n ^ m) [m = target string length, n = array length]
     * Space Complexity = O(m ^ 2)
     *
     * @param words  dictionary of words
     * @param target    A target string to be derived
     * @return number of ways the target string can be constructed, otherwise 0
     */
    public static int bruteForce(List<String> words, String target) {
        if (target.isEmpty()) return 1;
        int count = 0;
        for (String word : words) {
            if (target.startsWith(word)) {
                String remainder = target.substring(word.length());
                if (bruteForce(words, remainder) == 1) {
                    count += 1;
                }
            } else if (target.endsWith(word)) {
                String remainder = target.substring(0, target.indexOf(word));
                if (bruteForce(words, remainder) == 1) {
                    count += 1;
                }
            }
        }

        return count;
    }

    /**
     * Memoization approach to count number ways the target string can be constructed from given dictionary of words
     *
     * Time Complexity = O(n * m ^ 2) [m = target string length, n = array length]
     * Space Complexity = O(m ^ 2)
     *
     * @param words  dictionary of words
     * @param target    A target string to be derived
     * @return number of ways the target string can be constructed, otherwise 0
     */

    public static int memoization(List<String> words, String target) {
        Map<String, Integer> memo = new HashMap<>();
        return recurse(memo, words, target);
    }

    private static int recurse(Map<String, Integer> memo, List<String> words, String target) {
        if (target.isEmpty()) return 1;
        if (memo.containsKey(target)) return memo.get(target);

        int count = 0;
        for (String word : words) {
            if (target.startsWith(word)) {
                String remainder = target.substring(word.length());
                if (recurse(memo, words, remainder) == 1) {
                    count += 1;
                }
            } else if (target.endsWith(word)) {
                String remainder = target.substring(0, target.indexOf(word));
                if (recurse(memo, words, remainder) == 1) {
                    count += 1;
                }
            }
        }
        memo.put(target, count);
        return count;
    }
}
