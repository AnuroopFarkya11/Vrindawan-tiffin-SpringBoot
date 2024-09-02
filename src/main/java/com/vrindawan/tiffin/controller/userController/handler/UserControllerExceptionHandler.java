package com.vrindawan.tiffin.controller.userController.handler;

import com.vrindawan.tiffin.controller.userController.UserController;
import com.vrindawan.tiffin.controller.userController.exception.UserAlreadyExistsException;
import com.vrindawan.tiffin.controller.userController.exception.UserNotFoundException;
import com.vrindawan.tiffin.exception.ExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(UserControllerExceptionHandler.class);

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleUserAlreadyExists(UserAlreadyExistsException e) {
        logger.warn("User creation failed: {}", e.getMessage());
        return new ResponseEntity<>(new ExceptionResponse("User Already Exists", e.getMessage()), HttpStatus.CONFLICT);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleUserNotFound(UserNotFoundException e) {
        logger.warn("User Not found {}", e.getMessage());
        return new ResponseEntity<>(new ExceptionResponse("User Not Found Exception", e.getMessage()), HttpStatus.NOT_FOUND);
    }


}
