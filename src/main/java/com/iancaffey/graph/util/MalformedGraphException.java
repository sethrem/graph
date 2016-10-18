package com.iancaffey.graph.util;

/**
 * MalformedGraphException
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MalformedGraphException extends RuntimeException {
    public MalformedGraphException() {
        super();
    }

    public MalformedGraphException(String message) {
        super(message);
    }

    public MalformedGraphException(String message, Throwable cause) {
        super(message, cause);
    }

    public MalformedGraphException(Throwable cause) {
        super(cause);
    }

    protected MalformedGraphException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
