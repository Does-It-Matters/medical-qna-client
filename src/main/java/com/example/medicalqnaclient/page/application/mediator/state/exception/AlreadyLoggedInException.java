package com.example.medicalqnaclient.page.application.mediator.state.exception;

/**
 * 이미 로그인 했지만 로그인 요청 시 발생하는 예외 클래스
 */
public class AlreadyLoggedInException extends RuntimeException {

    public AlreadyLoggedInException() {
        super();
    }

    public AlreadyLoggedInException(String message) {
        super(message);
    }

    public AlreadyLoggedInException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyLoggedInException(Throwable cause) {
        super(cause);
    }
}
