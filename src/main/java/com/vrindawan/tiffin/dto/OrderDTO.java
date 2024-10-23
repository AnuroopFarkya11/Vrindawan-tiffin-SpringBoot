package com.vrindawan.tiffin.dto;

import com.vrindawan.tiffin.model.food.FoodEntity;
import com.vrindawan.tiffin.model.order.OrderStatus;
import com.vrindawan.tiffin.model.order.PaymentMethod;
import com.vrindawan.tiffin.model.order.PaymentStatus;
import com.vrindawan.tiffin.model.user.Address;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderDTO {

    private ObjectId id;

    @NotNull(message = "User ID cannot be null")
    private String userId;

    @NotEmpty(message = "Order must have at least one food item")
//    private List<@Valid FoodDTO> foodItems;
    private List<FoodEntity> foodItems;

    @NotNull(message = "Order time cannot be null")
    private LocalDateTime orderTime;

    @NotBlank(message = "Order status cannot be blank")
    private OrderStatus status; // Example: PENDING, DELIVERED, CANCELED

    @NotNull(message = "Total amount cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Total amount must be greater than 0")
    private BigDecimal totalAmount;

    @NotBlank(message = "Delivery address cannot be blank")
    private Address deliveryAddress;

    @NotBlank(message = "Payment status cannot be blank")
    private PaymentStatus paymentStatus; // Example: PAID, PENDING

    @NotBlank(message = "Payment method cannot be blank")
    private PaymentMethod paymentMethod; // Example: CASH, CARD, UPI

/*    @FutureOrPresent(message = "Estimated delivery time cannot be in the past")
    private LocalDateTime estimatedDeliveryTime;*/

//    private String deliveryPersonId;

  /*  @NotBlank(message = "Order type cannot be blank")
    private String orderType; // Example: DINE_IN, TAKE_OUT, DELIVERY
*/
    private String orderNotes;

/*
    @DecimalMin(value = "0.0", message = "Discount cannot be negative")
    private BigDecimal discount;

    @DecimalMin(value = "0.0", message = "Tax amount cannot be negative")
    private BigDecimal taxAmount;
*/

    private LocalDateTime orderCompletionTime;
    private String orderTrackingId;

    private boolean isCancelled;

    // Getters, Setters, and Constructor
}
