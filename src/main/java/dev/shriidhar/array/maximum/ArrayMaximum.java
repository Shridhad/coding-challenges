package dev.shriidhar.array.maximum;

import java.util.List;
import java.util.stream.IntStream;

public class ArrayMaximum {

    public static String find(int[] array) {
        String result = String.join("", lexSort(array));
        return result.startsWith("0") ? "0" : result;
    }

    private static List<String> lexSort(int[] array) {
        return IntStream.of(array)
                .mapToObj(String::valueOf)
                .sorted((first, second) -> (second + first).compareTo(first + second))
                .toList();
    }
}
