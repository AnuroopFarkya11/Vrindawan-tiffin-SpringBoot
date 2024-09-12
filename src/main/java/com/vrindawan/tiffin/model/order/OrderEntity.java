package com.vrindawan.tiffin.model.order;

import com.vrindawan.tiffin.model.food.FoodEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.core.annotation.Order;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
@Document(collection = "Order")
@Builder
public class OrderEntity {

    @Id
    private ObjectId ordId;
    private String uid;
    private List<FoodEntity> items = new ArrayList<>();
    private LocalDateTime ordTime;
    private OrderStatus status;
    private BigDecimal totalAmount;
    private String deliveryAddress;
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
    private boolean isCancelled;
}
