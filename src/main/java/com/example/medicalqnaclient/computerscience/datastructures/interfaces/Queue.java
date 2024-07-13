package com.example.medicalqnaclient.computerscience.datastructures.interfaces;

public interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    E peek();
    boolean isEmpty();
    int size();
}
