package com.example.medicalqnaclient.exercise.datastructures.interfaces;

public interface List<E> {
    void add(E element);
    // void addFirst(E element);
    // void addLast(E element);
    void add(int index, E element);
    E get(int index);
    void remove(int index);
    // void removeFirst();
    // void removeLast();
    int size();
    boolean isEmpty();
}
