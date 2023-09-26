package dev.shriidhar.leetcode.construct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CountConstructTest {

    @ParameterizedTest
    @MethodSource("dataSource")
    void bruteForce(List<String> words, String target, int expected) {
        Assertions.assertEquals(expected, CountConstruct.bruteForce(words, target));
    }

    public static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(List.of("ab", "abc", "cd", "def", "abcd"), "abcdef", 2),
                Arguments.of(List.of("purp", "p", "ur", "le", "purpl"), "purple", 2),
                Arguments.of(List.of("bo", "rd", "ska", "ate", "t", "sk", "boar"), "skateboard", 0),
                Arguments.of(List.of("a", "p", "ent", "enter", "ot", "o", "t"), "enterpotentpot", 1),
                Arguments.of(List.of("e", "ee", "eeee", "eeee", "eeeee", "eeeeeee", "eeeeee", "eeeeeee"), "eeeeeeeeeeeeeeeeeeeeeeeeeeeef", 0)
        );
    }

}