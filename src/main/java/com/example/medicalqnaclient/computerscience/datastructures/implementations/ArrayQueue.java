package com.example.medicalqnaclient.computerscience.datastructures.implementations;

import com.example.medicalqnaclient.computerscience.datastructures.exceptions.MyEmptyQueueException;
import com.example.medicalqnaclient.computerscience.datastructures.interfaces.Queue;

public class ArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_SIZE = 8;

    private Object[] queue;
    private int head;
    private int tail;

    public ArrayQueue(int size) {
        queue = new Object[size];
        head = tail = 0;
    }

    public ArrayQueue() {
        this(DEFAULT_SIZE);
    }

    @Override
    public void enqueue(E element) {
        if(isFull()) {
            resizeBigger();
        }
        
        simpleEnqueue(element);
    }

    private boolean isFull() {
        return head == (tail + 1) % queue.length;
    }

    private void resizeBigger() {
        resize(queue.length * 2);
    }

    private void resize(int size) {
        Object[] newQueue = new Object[size];

        int i;
        for (i = 0; i < queue.length && i < newQueue.length; i++) {
            newQueue[i] = queue[(head + i)% queue.length];
        }

        head = 0;
        tail = i - 1;
        queue = newQueue;
    }

    private void simpleEnqueue(E element) {
        tail = (tail + 1) % queue.length;
        queue[tail] = element;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new MyEmptyQueueException();
        }

        E element = simpleDequeue();

        if (hasTooMuchEmptySpace()) {
            resizeSmaller();
        }

        return element;
    }

    private boolean hasTooMuchEmptySpace() {
        return size() < queue.length / 4;
    }

    private void resizeSmaller() {
        int size = queue.length / 2;
        if (size >= DEFAULT_SIZE) {
            resize(size);
        }
    }

    private E simpleDequeue() {
        E element = (E) queue[tail];
        tail = (tail - 1) % queue.length;

        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new MyEmptyQueueException();
        }

        return (E) queue[(head + 1) % queue.length];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public int size() {
        if (head == tail) {
            return 0;
        } else if (head < tail) {
            return tail - head;
        } else {
            return queue.length - (head - tail);
        }
    }
}
