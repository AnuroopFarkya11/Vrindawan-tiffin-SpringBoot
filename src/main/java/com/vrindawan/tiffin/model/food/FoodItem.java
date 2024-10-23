package com.vrindawan.tiffin.model.food;

import com.vrindawan.tiffin.dto.FoodDTO;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Document(collection = "Food_Menu")
public class FoodItem {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String name;
    private String hindiName;
    private String description;
    private String hindiDescription;
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


    public static FoodItem fromDto(FoodDTO dto) {
        return FoodItem.builder()
                .id(dto.getId())
                .name(dto.getName())
                .hindiName(dto.getHindiName())
                .description(dto.getDescription())
                .hindiDescription(dto.getHindiDescription())
                .price(dto.getPrice())
                .imageUrl(dto.getImageUrl())
                .isAvailable(dto.isAvailable())
                .quantity(dto.getQuantity())
                .category(dto.getCategory())
                .createdAt(LocalDateTime.now()) // or dto.getCreatedAt() if you want to use the DTO's timestamp
                .updatedAt(LocalDateTime.now()) // or dto.getUpdatedAt() if you want to use the DTO's timestamp
                .isOnOffer(dto.isOnOffer())
                .discount(dto.getDiscount())
                .preparationTime(dto.getPreparationTime())
                .nutritionalInfo(dto.getNutritionalInfo())
                .averageRating(dto.getAverageRating())
                .reviewCount(dto.getReviewCount())
                .cuisine(dto.getCuisine())
                .mealType(dto.getMealType())
                .tags(dto.getTags())
                .isDailySpecial(dto.isDailySpecial())
                .isCustomizable(dto.isCustomizable())
                .specialInstructions(dto.getSpecialInstructions())
                .ingredients(dto.getIngredients())
                .isPartOfMealPlan(dto.isPartOfMealPlan())
                .weight(dto.getWeight())
                .servingSize(dto.getServingSize())
                .isDietFriendly(dto.isDietFriendly())
                .allergens(dto.getAllergens())
                .calories(dto.getCalories())
                .containerType(dto.getContainerType())
                .packagingCost(dto.getPackagingCost())
                .isAvailableForTakeout(dto.isAvailableForTakeout())
                .isAvailableForDelivery(dto.isAvailableForDelivery())
                .isAvailableForPickup(dto.isAvailableForPickup())
                .largeOrderPreparationTime(dto.getLargeOrderPreparationTime())
                .maxOrderQuantity(dto.getMaxOrderQuantity())
                .nextAvailableDate(dto.getNextAvailableDate())
                .isSeasonal(dto.isSeasonal())
                .build();
    }

    public FoodDTO toDto() {
        return FoodDTO.builder()
                .id(this.id)
                .name(this.name)
                .hindiName(this.hindiName)
                .description(this.description)
                .hindiDescription(this.hindiDescription)
                .price(this.price)
                .imageUrl(this.imageUrl)
                .isAvailable(this.isAvailable)
                .quantity(this.quantity)
                .category(this.category)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .isOnOffer(this.isOnOffer)
                .discount(this.discount)
                .preparationTime(this.preparationTime)
                .nutritionalInfo(this.nutritionalInfo)
                .averageRating(this.averageRating)
                .reviewCount(this.reviewCount)
                .cuisine(this.cuisine)
                .mealType(this.mealType)
                .tags(this.tags)
                .isDailySpecial(this.isDailySpecial)
                .isCustomizable(this.isCustomizable)
                .specialInstructions(this.specialInstructions)
                .ingredients(this.ingredients)
                .isPartOfMealPlan(this.isPartOfMealPlan)
                .weight(this.weight)
                .servingSize(this.servingSize)
                .isDietFriendly(this.isDietFriendly)
                .allergens(this.allergens)
                .calories(this.calories)
                .containerType(this.containerType)
                .packagingCost(this.packagingCost)
                .isAvailableForTakeout(this.isAvailableForTakeout)
                .isAvailableForDelivery(this.isAvailableForDelivery)
                .isAvailableForPickup(this.isAvailableForPickup)
                .largeOrderPreparationTime(this.largeOrderPreparationTime)
                .maxOrderQuantity(this.maxOrderQuantity)
                .nextAvailableDate(this.nextAvailableDate)
                .isSeasonal(this.isSeasonal)
                .build();
    }

}
