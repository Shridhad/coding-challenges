package dev.shriidhar.leetcode.construct;

import java.util.ArrayList;
import java.util.List;

public class AllConstruct {

    /**
     * Brute Force approach to derive all possible combinations to construct the target string from given dictionary of words
     *
     * Time Complexity = O(m * n ^ m) [m = target sum, n = array length]
     * Space Complexity = O(m ^ 2)
     *
     * @param words  dictionary of words
     * @param target    A target string to be derived
     * @return list of combinations the target string can be constructed, otherwise empty list
     */
    public static List<List<String>> bruteForce(List<String> words, String target) {
        if (target.isEmpty()) {
            ArrayList<List<String>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            return list;
        }

        List<List<String>> combinations = new ArrayList<>();
        for (String word : words) {
            if (target.startsWith(word)) {
                String remainder = target.substring(word.length());
                var result = bruteForce(words, remainder);
                combinations.addAll(result.stream().peek(ways -> ways.add(0, word)).toList());
            }
        }

        return combinations;
    }

}
