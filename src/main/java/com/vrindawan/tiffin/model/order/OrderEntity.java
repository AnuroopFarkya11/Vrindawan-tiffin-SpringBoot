package com.vrindawan.tiffin.model.order;

import com.vrindawan.tiffin.model.food.FoodEntity;
import com.vrindawan.tiffin.model.food.FoodItem;
import com.vrindawan.tiffin.model.user.Address;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Slf4j
@Document(collection = "Order")
public class OrderEntity {

    @Id
    private ObjectId id;
    private int odrId = new Random().nextInt();
    private String uid;
    private List<FoodEntity> items = new ArrayList<>();
    private LocalDateTime ordTime;
    private OrderStatus status=OrderStatus.PENDING;
    private BigDecimal totalAmount;
    @DBRef
    private Address deliveryAddress;
    private PaymentStatus paymentStatus; // Example: PAID, PENDING
    private PaymentMethod paymentMethod; // Example: CASH, CARD, UPI
    private LocalDateTime estimatedDeliveryTime;
    private String deliveryPersonId;
    private String orderType; // Example: DINE_IN, TAKE_OUT, DELIVERY
    private String orderNotes;
    private BigDecimal discount;
    private BigDecimal taxAmount;
    private LocalDateTime orderCompletionTime;
    private String orderTrackingId;
    private boolean isCancelled=false;
}
