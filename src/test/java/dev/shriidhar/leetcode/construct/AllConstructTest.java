package dev.shriidhar.leetcode.construct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AllConstructTest {

    @ParameterizedTest
    @MethodSource("dataSource")
    void bruteForce(List<String> words, String target, List<List<String>> expected) {
        Assertions.assertEquals(expected, AllConstruct.bruteForce(words, target));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    void memoization(List<String> words, String target, List<List<String>> expected) {
        Assertions.assertEquals(expected, AllConstruct.bruteForce(words, target));
    }

    public static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(List.of("ab", "abc", "cd", "def", "abcd"), "abcdef", List.of(List.of("abc", "def"))),
                Arguments.of(List.of("purp", "p", "ur", "le", "purpl"), "purple", List.of(List.of("purp", "le"), List.of("p", "ur", "p", "le"))),
                Arguments.of(List.of("bo", "rd", "ska", "ate", "t", "sk", "boar"), "skateboard", List.of()),
                Arguments.of(List.of("a", "p", "ent", "enter", "ot", "t"), "enterpotentpot", List.of(List.of("enter", "p", "ot", "ent", "p", "ot"))),
                Arguments.of(List.of("e", "ee", "eeee", "eeee", "eeeee", "eeeeeee", "eeeeee", "eeeeeee"), "eeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of())
        );
    }


}