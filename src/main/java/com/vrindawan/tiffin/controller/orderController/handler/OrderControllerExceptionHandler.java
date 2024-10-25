package com.vrindawan.tiffin.controller.orderController.handler;

import com.vrindawan.tiffin.controller.orderController.exceptions.InvalidOrderIdException;
import com.vrindawan.tiffin.controller.orderController.exceptions.OrderNotFoundException;
import com.vrindawan.tiffin.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(name = "OrderController")
public class OrderControllerExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    ResponseEntity<ExceptionResponse> handleOrderNotFoundException(OrderNotFoundException e) {
        return new ResponseEntity<ExceptionResponse>(new ExceptionResponse("There is no such order.", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidOrderIdException.class)
    ResponseEntity<ExceptionResponse> handleInvalidOrdIdException(InvalidOrderIdException e){
        return new ResponseEntity<>(new ExceptionResponse("Invalid Order ID.",e.getMessage()),HttpStatus.BAD_REQUEST);
    }


}
