package com.vrindawan.tiffin.service;

import com.vrindawan.tiffin.controller.orderController.exceptions.InvalidOrderIdException;
import com.vrindawan.tiffin.controller.orderController.exceptions.OrderNotFoundException;
import com.vrindawan.tiffin.controller.userController.exception.UserNotFoundException;
import com.vrindawan.tiffin.dto.OrderDTO;
import com.vrindawan.tiffin.model.order.OrderEntity;
import com.vrindawan.tiffin.model.user.Address;
import com.vrindawan.tiffin.model.user.UserEntity;
import com.vrindawan.tiffin.repository.OrderRepository;
import com.vrindawan.tiffin.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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

    @Autowired
    private AddressService addressService;

    @Transactional
    public OrderEntity createOrder(OrderDTO orderDTO) {
        log.info("Attempting to create order ");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Long number = Long.parseLong(name);
        Optional<UserEntity> user = userRepository.findByphoneNumber(number);

        if (user.isPresent()) {
            OrderEntity orderEntity = new OrderEntity();
            UserEntity userEntity = user.get();
            Address address = orderDTO.getDeliveryAddress();
            boolean res = addressService.isAddressPresent(address);
            log.info("Does address exists : {}", res);
            if (!res) {
                address.setAddressId(new ObjectId().toHexString());
                address.setCreatedAt(LocalDateTime.now());
                address.setUpdatedAt(LocalDateTime.now());
                Address savedAddress = addressService.addAddress(address);
                orderEntity.setDeliveryAddress(savedAddress);
                userEntity.getAddresses().add(address);
            }
            orderEntity.setUid(userEntity.getUid());
            orderEntity.setItems(orderDTO.getFoodItems());
            orderEntity.setOrdTime(LocalDateTime.now());
            orderEntity.setTotalAmount(orderDTO.getTotalAmount());
            orderEntity.setPaymentStatus(orderEntity.getPaymentStatus());
            orderEntity.setPaymentMethod(orderEntity.getPaymentMethod());
            OrderEntity saved = orderRepository.save(orderEntity);
            userEntity.getOrderEntities().add(saved);
            userRepository.save(userEntity);
            return saved;
        }

        throw new UserNotFoundException("Unable to find user");
    }


    @Transactional
    public List<OrderEntity> getAllOrders() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String numberStr = authentication.getName();
        long parsed = Long.parseLong(numberStr);
        Optional<UserEntity> user = userRepository.findByphoneNumber(parsed);

        if(user.isPresent())
        {
            String uid = user.get().getUid();
            List<OrderEntity> order = orderRepository.findByuid(uid);
            return order;

        }
        throw new UserNotFoundException("Unable to find user while fetching order list");
    }


    @Transactional
    public OrderEntity getOrderById(int ordId) {

        if (ordId == 0) {
            throw new InvalidOrderIdException();
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String numberStr = authentication.getName();
        long parsed = Long.parseLong(numberStr);
        Optional<UserEntity> user = userRepository.findByphoneNumber(parsed);

        if (user.isEmpty()) {
            throw new UserNotFoundException("User Not Found.");
        }

        UserEntity userEntity = user.get();
        List<OrderEntity> orderEntities = userEntity.getOrderEntities();

        for (OrderEntity orderEntity : orderEntities) {
            if (orderEntity.getOdrId() == ordId) {
                return orderEntity;
            }
        }
        throw new OrderNotFoundException(ordId);
    }
}