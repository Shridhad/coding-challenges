package dev.shriidhar.leetcode.tree;

public class Node<T> {
    T element;
    Node<T> left;
    Node<T> right;

    public Node(T element) {
        this.element = element;
    }

    public Node<T> addLeft(Node<T> left) {
        this.left = left;
        return this;
    }

    public Node<T> addRight(Node<T> right) {
        this.right = right;
        return this;
    }

    public Node<T> addLeft(T left) {
        return addLeft(new Node<T>(left));
    }

    public Node<T> addRight(T left) {
        return addRight(new Node<T>(left));
    }

    public T value() {
        return this.element;
    }

    public Node<T> right() {
        return this.right;
    }

    public Node<T> left() {
        return this.left;
    }
}

