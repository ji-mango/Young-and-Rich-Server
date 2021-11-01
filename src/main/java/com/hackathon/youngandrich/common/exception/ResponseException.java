package com.hackathon.youngandrich.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public abstract class ResponseException extends RuntimeException{
    protected HttpStatus httpStatus;

    protected ResponseException(HttpStatus httpStatus) {
        this(httpStatus, httpStatus.getReasonPhrase());
    }
    protected ResponseException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}

