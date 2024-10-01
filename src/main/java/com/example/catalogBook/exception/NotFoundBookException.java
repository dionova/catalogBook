package com.example.catalogBook.exception;

public class NotFoundBookException extends RuntimeException{
    public NotFoundBookException(String message) {
        super(message);
    }
}
