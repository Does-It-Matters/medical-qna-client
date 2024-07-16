package com.example.medicalqnaclient.computerscience.datastructures.interfaces;

public interface Tree<E> {
    void insert(E element);
    void delete(E element) throws Exception;
    boolean contains(E element);
    void traverse();
}
