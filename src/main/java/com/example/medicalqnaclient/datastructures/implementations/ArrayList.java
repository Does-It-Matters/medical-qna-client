package com.example.medicalqnaclient.datastructures.implementations;

import com.example.medicalqnaclient.datastructures.interfaces.List;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_SIZE = 8;

    private Object[] list;
    private int last;

    public ArrayList(int size) {
        list = new Object[size];
        last = -1;
    }

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    @Override
    public void add(E e) {
        if (isFull()) {
            resizeBigger();
        }

        simpleAdd(e);
    }

    private boolean isFull() {
        return last == list.length - 1;
    }

    private void resizeBigger() {
        resize(list.length * 2);
    }

    private void resize(int size) {
        Object[] newList = new Object[size];
        for (int i = 0; i < list.length && i < newList.length; i++) { // 효율성 검토
            newList[i] = list[i];
        }
        list = newList;
    }

    private void simpleAdd(E e) {
        last++;
        list[last] = e;
    }

    @Override
    public void add(int index, E e) {
        if (out(index)) {
            throw new RuntimeException("list out"); // 꽉찬 리스트에서 마지막 원소 뒤 삽입은 확인해볼 요소
        }

        shiftRight(index);
        simpleAdd(index, e);
    }

    private boolean out(int index) {
        return index > list.length - 1 || index < 0;
    }

    private void shiftRight(int index) {
        if (isFull()) {
            resizeBigger();
        }

        for (int i = last; i >= index; i--) {
            list[i + 1] = list[i];
        }
    }

    private void simpleAdd(int index, E e) {
        list[index] = e;
        last++;
    }

    @Override
    public E get(int index) {
        if (out(index)) {
            throw new RuntimeException("array excess");
        }

        return (E) list[index];
    }

    @Override
    public void remove(int index) {
        if (out(index)) {
            throw new RuntimeException("list out");
        }

        shiftLeft(index);
        last--;

        // 배열 크기 감소는 나중
    }

    private void shiftLeft(int index) {
        for (int i = last - 1; i >= index; i++) {
            list[i] = list[i + 1];
        }
    }

    @Override
    public int size() {
        return last + 1;
    }

    @Override
    public boolean isEmpty() {
        return last < 0;
    }
}
