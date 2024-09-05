package com.vrindawan.tiffin.controller.foodController.exception;

public class FoodNotFoundException extends RuntimeException {

    public FoodNotFoundException(String message) {
        super(message);
    }

    public FoodNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
