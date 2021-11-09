package com.hackathon.youngandrich.common.exception;

import org.springframework.http.HttpStatus;

public class AlreadyExistException extends ResponseException {
    public AlreadyExistException() {
        super(HttpStatus.CONFLICT);
    }
    public AlreadyExistException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
