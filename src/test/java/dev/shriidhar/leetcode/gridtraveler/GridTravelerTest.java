package dev.shriidhar.leetcode.gridtraveler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GridTravelerTest {

    @ParameterizedTest()
    @MethodSource("provideTestData")
    void memoization(int rows, int columns, long expected) {
        Assertions.assertEquals(GridTraveler.memoization(rows, columns), expected);
    }

    @ParameterizedTest()
    @MethodSource("provideTestData")
    void tabulation(int rows, int columns, long expected) {
        Assertions.assertEquals(GridTraveler.tabulation(rows, columns), expected);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(0, 1, 0),
                Arguments.of(1, 0, 0),
                Arguments.of(1, 1, 1),
                Arguments.of(2, 3, 3),
                Arguments.of(18, 18, 2333606220L),
                Arguments.of(50, 50, 858110510779117752L)
        );
    }
}