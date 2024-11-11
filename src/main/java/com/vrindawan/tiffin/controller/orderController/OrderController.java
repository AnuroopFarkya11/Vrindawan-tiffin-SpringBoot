package com.vrindawan.tiffin.controller.orderController;

import com.vrindawan.tiffin.dto.OrderDTO;
import com.vrindawan.tiffin.model.order.OrderEntity;
import com.vrindawan.tiffin.model.order.OrderStatus;
import com.vrindawan.tiffin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;




    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody OrderDTO orderDTO){
        OrderEntity order = orderService.createOrder(orderDTO);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<?> getUserOrders(){
        List<OrderEntity> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    @GetMapping("/id")
    public ResponseEntity<?> getOrderStatus(@PathVariable String id){
        OrderEntity order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    




//commit

}
