package dev.shriidhar.leetcode.cansum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CanSumTest {

    @ParameterizedTest()
    @MethodSource("provideTestData")
    void bruteForce(List<Long> list, long target, boolean expected) {
        Assertions.assertEquals(expected, CanSum.bruteForce(target, list));
    }

    @ParameterizedTest()
    @MethodSource("provideTestData")
    void memoization(List<Long> list, long target, boolean expected) {
        Assertions.assertEquals(expected, CanSum.memoization(target, list));
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(List.of(4L, 6L ,8L), 10, true),
                Arguments.of(List.of(4L, 6L, 8L), 11, false),
                Arguments.of(List.of(4L), 12, true),
                Arguments.of(List.of(14L, 7L), 300, false)
        );
    }
}