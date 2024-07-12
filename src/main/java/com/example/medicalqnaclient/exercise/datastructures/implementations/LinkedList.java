package com.example.medicalqnaclient.exercise.datastructures.implementations;

import com.example.medicalqnaclient.exercise.datastructures.interfaces.List;

public class LinkedList<E> implements List<E> {
    private class Node<E> {
        private E data;
        private Node next;

        Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(E data) {
            this.data = data;
            next = null;
        }
    }

    private Node<E> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(E e) {
        addFirst(e);
    }

    public void addFirst(E e) {
        if (isEmpty()) {
            head = new Node<E>(e);
        } else {
            head = new Node<E>(e, head);
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newLast = new Node<E>(e);
        if (isEmpty()) {
            head = newLast;
        } else {
            Node<E> last = getLastNode();
            last.next = newLast;
        }
        size++;
    }

    private Node<E> getLastNode() {
        Node<E> current = head;
        while (current != null) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void add(int index, E e) {
        if (out(index)) {
            throw new RuntimeException("out index to add");
        }

        if (index == 0) {
            addFirst(e);
        } else {
            Node<E> current = getNode(index - 1);
            current.next = new Node(e, current.next);
        }

        size++;
    }

    private boolean out(int index) {
        return index < 0 || index > size;
    }

    private Node<E> getNode(int index) {
        Node<E> current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }

        return current;
    }

    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    @Override
    public void remove(int index) {

    }

    public void removeFirst(E e) {

    }

    public void removeLast(E e) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
