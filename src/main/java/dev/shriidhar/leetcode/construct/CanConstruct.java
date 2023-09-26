package dev.shriidhar.leetcode.construct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanConstruct {

    /**
     * Brute Force approach to derive if target string can be generated from given dictionary of words
     *
     * Time Complexity = O(m * n ^ m) [m = target sum, n = array length]
     * Space Complexity = O(m ^ 2)
     *
     * @param words  dictionary of words
     * @param target    A target string to be derived
     * @return true if target string can be generated from words dictionary, otherwise false.
     */
    public static boolean bruteForce(List<String> words, String target) {
        if (target.isEmpty()) return true;

        for (String word : words) {
            if (target.startsWith(word)) {
                String remainder = target.substring(word.length());
                if (bruteForce(words, remainder)) {
                    return true;
                }
            } else if (target.endsWith(word)) {
                String remainder = target.substring(0, target.indexOf(word));
                if (bruteForce(words, remainder)) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * Memoization approach to derive if target string can be generated from given dictionary of words
     *
     * Time Complexity = O(n * m ^ 2) [m = target sum, n = array length]
     * Space Complexity = O(m ^ 2)
     *
     * @param words  dictionary of words
     * @param target    A target string to be derived
     * @return true if target string can be generated from words dictionary, otherwise false.
     */
    public static boolean memoization(List<String> words, String target) {
        Map<String, Boolean> memo = new HashMap<>();
        return recurse(memo, words, target);
    }

    private static boolean recurse(Map<String, Boolean> memo, List<String> words, String target) {
        if (target.isEmpty()) return true;
        if (memo.containsKey(target)) return memo.get(target);

        for (String word : words) {
            if (target.startsWith(word)) {
                String remainder = target.substring(word.length());
                memo.put(target, recurse(memo, words, remainder));
                if (memo.get(target)) {
                    return true;
                }
            } else if (target.endsWith(word)) {
                String remainder = target.substring(0, target.indexOf(word));
                memo.put(target, recurse(memo, words, remainder));
                if (memo.get(target)) {
                    return true;
                }
            }
        }

        return false;
    }
}
