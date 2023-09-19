package dev.shriidhar.array.reduction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayReductionTest {

    @ParameterizedTest()
    @MethodSource("provideTestData")
    void reduce(List<Integer> list, int result) {
        Assertions.assertEquals(ArrayReduction.reduce(list), result);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(List.of(4,6,8), 28),
                Arguments.of(List.of(1, 2, 3), 9),
                Arguments.of(List.of(1, 2, 3, 4), 19)
        );
    }
}