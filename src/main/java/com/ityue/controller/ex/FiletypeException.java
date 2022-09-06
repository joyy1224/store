package com.ityue.controller.ex;

public class FiletypeException extends FileUploadException{
    public FiletypeException() {
        super();
    }

    public FiletypeException(String message) {
        super(message);
    }

    public FiletypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FiletypeException(Throwable cause) {
        super(cause);
    }

    protected FiletypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
