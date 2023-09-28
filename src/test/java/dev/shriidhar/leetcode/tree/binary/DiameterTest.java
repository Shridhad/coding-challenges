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
    void bruteForce(Node<String> root, long expected) {
        Assertions.assertEquals(expected, Diameter.bruteForce(root));
    }

    @ParameterizedTest()
    @MethodSource("testData")
    void memoization(Node<String> root, long expected) {
        Assertions.assertEquals(expected, Diameter.optimized(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new Node<>("root").addLeft("left").addRight("right"), 3),
                Arguments.of(getTree(), 7),
                Arguments.of(getIntTree(), 9)
        );
    }

    private static Node<String> getTree() {
        Node<String> root = new Node<>("1").addLeft("2").addRight("4");

        root.left().addLeft(new Node<>("3").addLeft("5"));
        root.right().addLeft(new Node<>("4").addRight("6"));
        return root;
    }

    private static Node<Integer> getIntTree() {
        Node<Integer> root = new Node<>(1).addLeft(2).addRight(3);
        root.left().addLeft(4);
        root.left().addRight(new Node<>(5).addLeft(6).addLeft(7));

        Node<Integer> node = new Node<>(9).addLeft(10).addRight(11);
        node.left().addRight(12);

        root.right().addRight(new Node<>(8).addRight(node));

        return root;
    }
}