package com.vrindawan.tiffin.controller.foodController.exception;

public class FoodAlreadyExistsException extends RuntimeException {

    public FoodAlreadyExistsException(String message) {
        super(message);
    }

    public FoodAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }


}
