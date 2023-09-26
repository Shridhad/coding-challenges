package dev.shriidhar.leetcode.construct;

import java.util.List;

public class CountConstruct {

    /**
     * Brute Force approach to count number ways the target string can be constructed from given dictionary of words
     *
     * Time Complexity = O(m * n ^ m) [m = target sum, n = array length]
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
}
