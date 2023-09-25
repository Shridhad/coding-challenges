package dev.shriidhar.leetcode.howsum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class HowSumTest {
    @ParameterizedTest()
    @MethodSource("provideTestData")
    void bruteForce(List<Long> list, long target, List<Long> expected) {
        Assertions.assertEquals(expected, HowSum.bruteForce(target, list));
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(List.of(4L, 6L, 8L), 10, List.of(6L, 4L)),
                Arguments.of(List.of(5L, 3L, 4L, 7L), 7, List.of(4L, 3L)),
                Arguments.of(List.of(4L, 6L, 8L), 11, null),
                Arguments.of(List.of(4L), 12, List.of(4L, 4L, 4L)),
                Arguments.of(List.of(7L, 14L), 300, null)
        );
    }
}