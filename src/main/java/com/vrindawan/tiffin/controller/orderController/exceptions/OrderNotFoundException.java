package com.vrindawan.tiffin.controller.orderController.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String id) {
        super("Unable to find order with id : " + id);
    }
}
