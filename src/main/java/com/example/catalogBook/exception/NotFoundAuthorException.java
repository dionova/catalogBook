package com.example.catalogBook.exception;

public class NotFoundAuthorException extends RuntimeException{
    public NotFoundAuthorException(String message) {
        super(message);
    }
}
