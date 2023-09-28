package dev.shriidhar.leetcode.tree.binary;

import dev.shriidhar.leetcode.tree.Node;

public class Diameter {

    /**
     * Brute Force approach to find the length of the longest path between two nodes in the tree.
     *
     * Time Complexity: O(n ^ 2) [n = nodes in the tree]
     * Space Complexity: O(n)
     *
     * @param root root node
     * @param <T>  Type of Node
     * @return the maximum length between two nodes
     */
    public static <T> long bruteForce(Node<T> root) {
        return diameter(root);
    }

    private static <T> long diameter(Node<T> node) {
        if (node == null) return 0;

        long leftHeight = height(node.left());
        long rightHeight = height(node.right());

        return Math.max(leftHeight + rightHeight + 1, Math.max(diameter(node.left()), diameter(node.right())));
    }

    private static <T> long height(Node<T> node) {
        if (node == null) return 0;

        return 1 + Math.max(height(node.left()), height(node.right()));
    }

    /**
     * Optimized approach to find the length of the longest path between two nodes in the tree.
     *
     * We will calculate the height and diameter in the same recursion and pass both up the tree for further calculation.
     *
     * Time Complexity: O(n) [n = nodes in the tree]
     * Space Complexity: O(n)
     *
     * @param root root node
     * @param <T>  Type of Node
     * @return the maximum length between two nodes
     */
    public static <T> long optimized(Node<T> root) {
        return recurse(root).diameter;
    }

    private static <T> MaxDH recurse(Node<T> node) {
        if (node == null) {
            return new MaxDH(0, 0);
        }

        var leftDH = recurse(node.left());
        var rightDH = recurse(node.right());

        long height = Math.max(leftDH.height(), rightDH.height()) + 1;
        long diameter = Math.max(leftDH.height() + rightDH.height() + 1,
                Math.max(leftDH.diameter(), +rightDH.diameter()));
        return new MaxDH(height, diameter);
    }


    record MaxDH(long height, long diameter) {
    }

}
