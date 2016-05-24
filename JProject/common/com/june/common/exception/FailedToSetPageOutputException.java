package com.june.common.exception;

public class FailedToSetPageOutputException extends Exception {

    private static final long serialVersionUID = 7141953743232698349L;

    public FailedToSetPageOutputException() {
        super();
    }

    public FailedToSetPageOutputException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedToSetPageOutputException(String message) {
        super(message);
    }

    public FailedToSetPageOutputException(Throwable cause) {
        super(cause);
    }

}
