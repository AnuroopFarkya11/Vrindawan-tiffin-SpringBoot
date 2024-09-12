package com.vrindawan.tiffin.service;

import com.vrindawan.tiffin.controller.userController.exception.UserNotFoundException;
import com.vrindawan.tiffin.dto.OrderDTO;
import com.vrindawan.tiffin.model.food.FoodEntity;
import com.vrindawan.tiffin.model.order.OrderEntity;
import com.vrindawan.tiffin.model.order.OrderStatus;
import com.vrindawan.tiffin.model.user.UserEntity;
import com.vrindawan.tiffin.repository.OrderRepository;
import com.vrindawan.tiffin.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public OrderEntity createOrder(OrderDTO orderDTO) {
        log.info("Attempting to create order ");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Long number = Long.parseLong(name);
        Optional<UserEntity> user = userRepository.findByphoneNumber(number);

        if (user.isPresent()) {
            OrderEntity orderEntity = OrderEntity.builder()
                    .uid(user.get().getUid())
                    .items(orderDTO.getFoodItems().stream().map(FoodEntity::fromDto).toList())
                    .ordTime(LocalDateTime.now())
                    .deliveryAddress(orderDTO.getDeliveryAddress())
                    .paymentStatus(orderDTO.getPaymentStatus())
                    .paymentMethod(orderDTO.getPaymentMethod())
                    .status(OrderStatus.PENDING)
                    .totalAmount(orderDTO.getTotalAmount())
                    .orderNotes(orderDTO.getOrderNotes())
                    .build();
            OrderEntity saved = orderRepository.save(orderEntity);
            user.get().getOrderEntities().add(saved);
            userRepository.save(user.get());
            return saved;
        }

        throw new UserNotFoundException("Unable to find user");


    }


    public List<OrderEntity> getAllOrders() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String numberStr = authentication.getName();
        long parsed = Long.parseLong(numberStr);
        Optional<UserEntity> user = userRepository.findByphoneNumber(parsed);

        if(user.isPresent())
        {
            String uid = user.get().getUid();
            List<OrderEntity> orderEntities = orderRepository.findByuid(uid);
            List<OrderEntity> orderEntities1 = user.get().getOrderEntities();

            return orderEntities;
        }
        throw new UserNotFoundException("Unable to find user while fetching order list");
    }

}
