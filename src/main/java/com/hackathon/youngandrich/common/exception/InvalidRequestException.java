package com.hackathon.youngandrich.common.exception;

import org.springframework.http.HttpStatus;

public class InvalidRequestException extends ResponseException{
    public InvalidRequestException() {
        super(HttpStatus.BAD_REQUEST);
    }
    public InvalidRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
