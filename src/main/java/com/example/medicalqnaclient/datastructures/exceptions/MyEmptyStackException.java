package com.example.medicalqnaclient.datastructures.exceptions;

public class MyEmptyStackException extends RuntimeException {
    public MyEmptyStackException() {
        super("stack is empty.");
    }

    public MyEmptyStackException(String message) {
        super(message);
    }
}
