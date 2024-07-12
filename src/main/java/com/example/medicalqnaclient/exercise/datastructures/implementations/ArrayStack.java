package com.example.medicalqnaclient.exercise.datastructures.implementations;

import com.example.medicalqnaclient.exercise.datastructures.exceptions.MyEmptyStackException;
import com.example.medicalqnaclient.exercise.datastructures.interfaces.Stack;

public class ArrayStack<E> implements Stack<E> {
    private final static int DEFAULT_SIZE = 8;

    private Object[] stack;
    private int top;

    public ArrayStack(int size) {
        stack = new Object[size];
        top = -1;
    }

    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    @Override
    public void push(E element) {
        if (isFull())  {
            resizeBigger();
        }

        simplePush(element);
    }

    private boolean isFull() {
        return top + 1 > stack.length - 1;
    }

    private void resizeBigger(){
        resize(stack.length * 2);
    }

    private void resize(int size) {
        Object[] newStack = new Object[size];

        for(int i = 0; i < stack.length && i < newStack.length; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }

    private void simplePush(E element) {
        top++;
        stack[top] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new MyEmptyStackException();
        }

        E e = simplePop();

        if (hasTooMuchEmptySpace()) {
            resizeSmaller();
        }

        return e;
    }

    private boolean hasTooMuchEmptySpace() {
        return top < stack.length / 4;
    }

    private void resizeSmaller(){
        int size = stack.length / 2;
        if (isEqualOrBiggerDefaultSize(size)) {
            resize(size);
        }
    }

    private boolean isEqualOrBiggerDefaultSize(int size) {
        return size >= DEFAULT_SIZE;
    }

    private E simplePop() {
        E e = (E) stack[top];
        top--;

        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new MyEmptyStackException();
        }

        return (E) stack[top];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return top + 1;
    }
}
