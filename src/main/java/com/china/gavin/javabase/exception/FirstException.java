package com.china.gavin.javabase.exception;

public class FirstException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Define Construct FirstException.
     */
    public FirstException() {
        super();
    }

    /**
     * Define Construct FirstException with message.
     * @param msg
     */
    public FirstException(String msg) {
        super(msg);
    }

    /**
     * Define Construct FirstException with Throwable
     * @param cause
     */
    public FirstException(Throwable cause) {
        super(cause);
    }

    /**
     * Define Construct FirstException with message and Throwable.
     * @param msg
     * @param cause
     */
    public FirstException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
