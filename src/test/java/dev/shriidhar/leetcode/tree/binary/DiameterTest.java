package dev.shriidhar.leetcode.tree.binary;

import dev.shriidhar.leetcode.tree.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DiameterTest {

    @ParameterizedTest()
    @MethodSource("testData")
    void findDiameter(Node<String> root, long expected) {
        Assertions.assertEquals(expected, Diameter.bruteForce(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new Node<>("root").addLeft("left").addRight("right"), 2),
                Arguments.of(getTree(), 4)
        );
    }

    private static Node<String> getTree() {
        Node<String> root = new Node<>("1").addLeft("2").addRight("4");

        root.left().addLeft(new Node<>("3").addLeft("5"));
        root.right().addLeft(new Node<>("4").addRight("6"));
        return root;
    }
}