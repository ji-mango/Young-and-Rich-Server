package com.hackathon.youngandrich.common.advice;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.util.NestedServletException;

import com.fasterxml.jackson.core.JsonParseException;

import com.hackathon.youngandrich.common.exception.ResponseException;
import com.hackathon.youngandrich.common.response.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(basePackages = "com.hackathon.youngandrich")
public class ControllerAdvice {

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<ResponseMessage> handleResponseException(ResponseException e) {
        log.warn(e.toString(), e);
        return new ResponseEntity<>(new ResponseMessage(e.getHttpStatus()), null, e.getHttpStatus());
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseMessage handleMethodNotAllowedException(HttpRequestMethodNotSupportedException e) {
        log.warn(e.toString(), e);
        return new ResponseMessage(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            IllegalArgumentException.class,
            JsonParseException.class,
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class,
            MethodArgumentNotValidException.class,
            NestedServletException.class,
    })
    public ResponseMessage handleIllegalArgumentException(Exception e) {
        log.warn(e.toString(), e);
        return new ResponseMessage(HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseMessage handleException(Exception e) {
        log.error(e.toString(), e);
        return new ResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
