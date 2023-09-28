package dev.shriidhar.leetcode.tree.binary;

import dev.shriidhar.leetcode.tree.Node;

public class Balanced {

    /**
     * Brute Force approach to find if the given tree is balanced or not
     * <p>
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

    /**
     * Upwards traversal approach to find if the tree is balanced.
     * <p>
     * We will be traversing the tree upwards, as soon as we find unbalanced node, we return early.
     * <p>
     * Time Complexity: O(n) [n = nodes in the tree]
     * Space Complexity: O(n)
     *
     * @param root root node
     * @param <T>  Type of Node
     * @return the maximum length between two nodes
     */
    public static <T> boolean upwards(Node<T> root) {
        return upwardsHeight(root) != -1;
    }

    private static <T> int upwardsHeight(Node<T> node) {
        if (node == null) return 0;

        int left = upwardsHeight(node.left());
        int right = upwardsHeight(node.right());

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
