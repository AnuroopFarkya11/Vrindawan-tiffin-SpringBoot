package com.vrindawan.tiffin.controller.orderController.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(int id) {
        super("Unable to find order with id : " + id);
    }
}
