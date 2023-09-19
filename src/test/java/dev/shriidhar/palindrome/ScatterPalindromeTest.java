package dev.shriidhar.palindrome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ScatterPalindromeTest {

    @ParameterizedTest()
    @MethodSource("provideTestData")
    void scatterPalindrome(String list, int result) {
        Assertions.assertEquals(ScatterPalindrome.scatterPalindrome(list), result);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("aabb", 9),
                Arguments.of("abc", 3),
                Arguments.of("bbrrg", 12)
        );
    }
}