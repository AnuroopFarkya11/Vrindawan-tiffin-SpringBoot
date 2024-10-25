package com.vrindawan.tiffin.controller.orderController.exceptions;

public class InvalidOrderIdException extends RuntimeException {

    public InvalidOrderIdException(){
        super("The order id is invalid.");
    }


}
