package com.hackathon.youngandrich.common.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ResponseException{
    public NotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
