package dev.shriidhar.leetcode.construct;

import java.util.List;

public class CanConstruct {

    /**
     * Brute Force approach to derive if target string can be generated from given dictionary of words
     *
     * Time Complexity = O(n ^ m) [m = target sum, n = array length]
     * Space Complexity = O(m)
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
}
