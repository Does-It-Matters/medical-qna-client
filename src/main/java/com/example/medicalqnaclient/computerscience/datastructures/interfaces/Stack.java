package com.example.medicalqnaclient.computerscience.datastructures.interfaces;

public interface Stack<E> {
    void push(E element);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}
