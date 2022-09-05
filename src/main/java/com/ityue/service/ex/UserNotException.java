package com.ityue.service.ex;

public class UserNotException extends ServiceException{
    public UserNotException() {
        super();
    }

    public UserNotException(String message) {
        super(message);
    }

    public UserNotException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotException(Throwable cause) {
        super(cause);
    }

    protected UserNotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
