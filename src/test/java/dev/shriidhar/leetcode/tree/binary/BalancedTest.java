package dev.shriidhar.leetcode.tree.binary;

import dev.shriidhar.leetcode.tree.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BalancedTest {

    @ParameterizedTest()
    @MethodSource("testData")
    void bruteForce(Node<String> root, boolean expected) {
        Assertions.assertEquals(expected, Balanced.bruteForce(root));
    }

    @ParameterizedTest()
    @MethodSource("testData")
    void upwardTraversal(Node<String> root, boolean expected) {
        Assertions.assertEquals(expected, Balanced.upwards(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new Node<>("root").addLeft("left").addRight("right"), true),
                Arguments.of(getTree(), false),
                Arguments.of(getIntTree(), false)
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