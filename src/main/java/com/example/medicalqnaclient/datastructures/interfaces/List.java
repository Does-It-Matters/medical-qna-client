package com.example.medicalqnaclient.datastructures.interfaces;

public interface List<E> {
    void add(E element);
    void add(int index, E element);
    E get(int index);
    void remove(int index);
    int size();
    boolean isEmpty();
}
