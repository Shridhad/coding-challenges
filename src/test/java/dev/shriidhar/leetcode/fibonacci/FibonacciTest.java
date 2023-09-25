package dev.shriidhar.leetcode.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FibonacciTest {

    @ParameterizedTest()
    @MethodSource("provideTestData")
    void recursive(int index, long expected) {
        Assertions.assertEquals(Fibonacci.recursive(index), expected);
    }

    @ParameterizedTest()
    @MethodSource("provideTestData")
    void memoization(int index, long expected) {
        Assertions.assertEquals(Fibonacci.memoization(index), expected);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(5, 5),
                Arguments.of(7, 13),
                Arguments.of(9, 34),
                Arguments.of(50, 12586269025L)
        );
    }
}