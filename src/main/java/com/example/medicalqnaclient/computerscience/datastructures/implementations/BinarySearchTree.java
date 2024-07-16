package com.example.medicalqnaclient.computerscience.datastructures.implementations;

import com.example.medicalqnaclient.computerscience.datastructures.interfaces.Tree;

public class BinarySearchTree<E extends Comparable<E>> implements Tree<E> {
    private static class Node<E> {
        private Node<E> parent;
        E element;
        private Node<E> left;
        private Node<E> right;

        Node(E element) {
            this.element = element;
        }
    }

    private Node<E> root;
    private int size;

    @Override
    public void insert(E element) {
        Node<E> newNode = new Node<>(element);

        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node<E> current = root;
        Node<E> parent = null;
        while (current != null) {
            parent = current;
            if (newNode.element.compareTo(current.element) <= 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (newNode.element.compareTo(parent.element) <= 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        newNode.parent = parent;
        size++;
    }

    @Override
    public void delete(E element) throws Exception {
        Node<E> current = root, parent = null;
        for (; current != null && element.equals(current.element); ) {
            parent = current;
        }

        if (current == null) {
            throw new Exception("empty. can't delete");
        }

        // 어렵다.
    }

    private Node<E> successor(Node<E> node) {
        // 오른쪽 자식 노드를 루트로 삼는 서브 트리의 최소 노드 찾기
            // 오른쪽 자식이 null이라면
            // 최소 노드 찾는 메소드 호출
        return null;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public void traverse() {

    }
}
