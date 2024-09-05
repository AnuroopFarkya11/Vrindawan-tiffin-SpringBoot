package com.vrindawan.tiffin.controller.foodController.handler;

import com.vrindawan.tiffin.controller.foodController.exception.FoodAlreadyExistsException;
import com.vrindawan.tiffin.controller.foodController.exception.FoodNotFoundException;
import com.vrindawan.tiffin.controller.userController.exception.UserAlreadyExistsException;
import com.vrindawan.tiffin.controller.userController.exception.UserNotFoundException;
import com.vrindawan.tiffin.exception.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
@Slf4j
public class FoodControllerExceptionHandler {


    @ExceptionHandler(FoodAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleUserAlreadyExists(FoodAlreadyExistsException e) {
        log.warn("Food creation failed: {}", e.getMessage());
        return new ResponseEntity<>(new ExceptionResponse("Food Already Exists", e.getMessage()), HttpStatus.CONFLICT);

    }

    @ExceptionHandler(FoodNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleUserNotFound(FoodNotFoundException e) {
        log.warn("Food Not found {}", e.getMessage());
        return new ResponseEntity<>(new ExceptionResponse("Food Not Found Exception", e.getMessage()), HttpStatus.NOT_FOUND);
    }


}
