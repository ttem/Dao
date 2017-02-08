package com.ttem.exception;

public class SourceTypeNotDefinedException extends DaoException{

    public SourceTypeNotDefinedException() {
    }

    public SourceTypeNotDefinedException(final String message) {
        super(message);
    }
}
