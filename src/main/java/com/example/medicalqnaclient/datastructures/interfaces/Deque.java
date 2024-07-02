package com.example.medicalqnaclient.datastructures.interfaces;

public interface Deque<E> {
    void addFirst(E element);
    void addLast(E element);
    E removeFirst();
    E removeLast();
    E peekFirst();
    E peekLast();
    boolean isEmpty();
    int size();
}
