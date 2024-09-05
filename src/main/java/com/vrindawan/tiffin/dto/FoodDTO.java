package com.vrindawan.tiffin.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {

    private ObjectId id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private boolean isAvailable;
    private int quantity;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isOnOffer;
    private double discount;
    private int preparationTime;
    private Map<String, Object> nutritionalInfo;
    private double averageRating;
    private int reviewCount;
    private String cuisine;
    private String mealType;
    private List<String> tags;
    private boolean isDailySpecial;
    private boolean isCustomizable;
    private String specialInstructions;
    private List<String> ingredients;
    private boolean isPartOfMealPlan;
    private double weight;
    private String servingSize;
    private boolean isDietFriendly;
    private List<String> allergens;
    private int calories;
    private String containerType;
    private double packagingCost;
    private boolean isAvailableForTakeout;
    private boolean isAvailableForDelivery;
    private boolean isAvailableForPickup;
    private int largeOrderPreparationTime;
    private int maxOrderQuantity;
    private LocalDateTime nextAvailableDate;
    private boolean isSeasonal;
}
