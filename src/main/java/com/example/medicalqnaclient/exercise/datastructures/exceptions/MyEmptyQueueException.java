package com.example.medicalqnaclient.exercise.datastructures.exceptions;

public class MyEmptyQueueException extends RuntimeException {
    public MyEmptyQueueException() {
        super("queue is empty.");
    }

    public MyEmptyQueueException(String message) {
        super(message);
    }
}
