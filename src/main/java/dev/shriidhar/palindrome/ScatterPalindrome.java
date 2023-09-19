package dev.shriidhar.palindrome;

import java.util.HashSet;
import java.util.Set;

public class ScatterPalindrome {

    public static int scatterPalindrome(String string) {
        int count = 0;
        for (int index = 0; index < string.length(); index++) {
            for(int innerIndex = index; innerIndex < string.length(); innerIndex++) {
                String substring = string.substring(index, innerIndex + 1);
                if (countScatteredPalindromes(substring, substring.length())) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean countScatteredPalindromes(String string, int length) {
        Set<Character> set = new HashSet<>();
        for (int index = 0; index < length; index++) {
            char charAt = string.charAt(index);
            if (set.contains(charAt)) {
                set.remove(charAt);
            } else {
                set.add(charAt);
            }
        }

        return length % 2 == 0 ? set.isEmpty() : set.size() == 1;
    }
}
