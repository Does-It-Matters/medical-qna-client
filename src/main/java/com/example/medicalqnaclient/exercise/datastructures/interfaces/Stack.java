package com.example.medicalqnaclient.exercise.datastructures.interfaces;

public interface Stack<E> {
    void push(E element);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}
