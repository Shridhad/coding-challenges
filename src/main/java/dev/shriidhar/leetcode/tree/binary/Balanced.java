package dev.shriidhar.leetcode.tree.binary;

import dev.shriidhar.leetcode.tree.Node;

public class Balanced {

    /**
     * Brute Force approach to find if the given tree is balanced or not
     *
     * Time Complexity: O(n ^ 2) [n = nodes in the tree]
     * Space Complexity: O(n)
     *
     * @param root root node
     * @param <T>  Type of Node
     * @return true if the tree is balanced, otherwise false
     */
    public static <T> boolean bruteForce(Node<T> root) {
        if (root == null) return true;

        if (Math.abs(height(root.left()) - height(root.right())) > 1) {
            return false;
        }

        return bruteForce(root.left()) && bruteForce(root.right());
    }

    private static <T> int height(Node<T> node) {
        if (node == null) return 0;

        return Math.max(height(node.left()), height(node.right())) + 1;
    }
}
