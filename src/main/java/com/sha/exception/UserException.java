package com.sha.exception;

import com.sha.exception.msg.UserMessage;

/**
 * @author Lisher
 */
public class UserException extends RuntimeException {
    private UserMessage userMessage;

    public UserException(UserMessage userMessage) {
        this.userMessage = userMessage;
    }

    public UserMessage getUserMessage() {
        return userMessage;
    }

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    protected UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
