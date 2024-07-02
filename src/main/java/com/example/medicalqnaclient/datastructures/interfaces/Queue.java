package com.example.medicalqnaclient.datastructures.interfaces;

public interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    E peek();
    boolean isEmpty();
    int size();
}
