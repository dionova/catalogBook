package com.example.catalogBook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CatalogBookApplicationExceptionHandler {
    private final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
    private final HttpStatus CONFLICT = HttpStatus.CONFLICT;


    @ExceptionHandler({UniqueConstraintViolationException.class})
    public ResponseEntity<Object> handlerUniqueConstraintViolationException(UniqueConstraintViolationException ex, WebRequest webRequest) {
        return ResponseEntity.status(CONFLICT).body(exceptionResponseModel(CONFLICT.value(), webRequest, ex));
    }

    @ExceptionHandler({NotFoundAuthorException.class})
    public ResponseEntity<Object> handlerNotFoundAuthorException(NotFoundAuthorException ex, WebRequest webRequest) {
        return ResponseEntity.status(NOT_FOUND).body(exceptionResponseModel(NOT_FOUND.value(), webRequest, ex));
    }

    @ExceptionHandler({NotFoundBookException.class})
    public ResponseEntity<Object> handlerNotFoundBookException(NotFoundBookException ex, WebRequest webRequest) {
        return ResponseEntity.status(NOT_FOUND).body(exceptionResponseModel(NOT_FOUND.value(), webRequest, ex));
    }

    private ExceptionResponseModel exceptionResponseModel(Integer statusCode, WebRequest webRequest, RuntimeException ex) {
        String path = ((ServletWebRequest)webRequest)
                .getRequest()
                .getRequestURI();

        String message = ex.getMessage();
        String exception = ex.getClass()
                .getName();

        return new ExceptionResponseModel(statusCode, path, message, exception);
    };
}
