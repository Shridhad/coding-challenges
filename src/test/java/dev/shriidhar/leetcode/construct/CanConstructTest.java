package dev.shriidhar.leetcode.construct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CanConstructTest {

    @ParameterizedTest
    @MethodSource("dataSource")
    void bruteForce(List<String> words, String target, boolean expected) {
        Assertions.assertEquals(expected, CanConstruct.bruteForce(words, target));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    void memoization(List<String> words, String target, boolean expected) {
        Assertions.assertEquals(expected, CanConstruct.memoization(words, target));
    }

    public static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(List.of("ab", "abc", "cd", "def", "abcd"), "abcdef", true),
                Arguments.of(List.of("bo", "rd", "ska", "ate", "t", "sk", "boar"), "skateboard", false),
                Arguments.of(List.of("a", "p", "ent", "enter", "ot", "o", "t"), "enterpotentpot", true),
                Arguments.of(List.of("e", "ee", "eeee", "eeee", "eeeee", "eeeeeee", "eeeeee", "eeeeeee"), "eeeeeeeeeeeeeeeeeeeeeeeeeeeef", false)
        );
    }
}