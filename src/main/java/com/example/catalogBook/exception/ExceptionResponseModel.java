package com.example.catalogBook.exception;

import java.io.Serializable;

public class ExceptionResponseModel implements Serializable {

    private Integer statusCode;
    private String path;
    private String message;
    private String exception;

    public ExceptionResponseModel(Integer status, String path, String message, String exception) {
        this.statusCode = status;
        this.path = path;
        this.message = message;
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
