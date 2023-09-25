package dev.shriidhar.array.maximum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ArrayMaximumTest {

    @ParameterizedTest()
    @MethodSource("provideTestData")
    void maximum(int[] list, String result) {
        Assertions.assertEquals(ArrayMaximum.find(list), result);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{3,30,34,5,9}, "9534330"),
                Arguments.of(new int[]{10, 2}, "210"),
                Arguments.of(new int[]{0, 0}, "0"),
                Arguments.of(new int[]{0, 10, 100, 0}, "1010000")
        );
    }
}