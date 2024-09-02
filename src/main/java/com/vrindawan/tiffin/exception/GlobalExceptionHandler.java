package com.vrindawan.tiffin.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        logger.error("Something went wrong {}", e.getMessage());
        return new ResponseEntity<>(new ExceptionResponse("Internal Server Error", e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


