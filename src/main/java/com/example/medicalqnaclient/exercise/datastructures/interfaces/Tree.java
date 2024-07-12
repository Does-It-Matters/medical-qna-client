package com.example.medicalqnaclient.exercise.datastructures.interfaces;

public interface Tree<E> {
    void insert(E element);
    void delete(E element);
    boolean contains(E element);
    void traverse();
}
