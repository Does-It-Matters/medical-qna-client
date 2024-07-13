package com.example.medicalqnaclient.computerscience.datastructures.interfaces;

public interface Tree<E> {
    void insert(E element);
    void delete(E element);
    boolean contains(E element);
    void traverse();
}
