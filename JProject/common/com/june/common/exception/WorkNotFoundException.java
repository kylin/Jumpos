package com.june.common.exception;

public class WorkNotFoundException extends Exception {

    private static final long serialVersionUID = 7141953743232698349L;

    public WorkNotFoundException() {
    	
        super();
    }

    public WorkNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkNotFoundException(String message) {
        super(message);
    }

    public WorkNotFoundException(Throwable cause) {
        super(cause);
    }

}
