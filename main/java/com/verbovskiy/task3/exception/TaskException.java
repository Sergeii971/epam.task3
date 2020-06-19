package com.verbovskiy.task3.exception;

public class TaskException extends Exception {
    public TaskException(String message) {
        super(message);
    }

    public TaskException() {
        super();
    }

    public TaskException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public TaskException(Throwable throwable) {
        super(throwable);
    }
}
