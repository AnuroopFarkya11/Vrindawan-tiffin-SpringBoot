package com.vrindawan.tiffin.model.food;


import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class FoodEntity {
    @DBRef
    private FoodItem item;
    private int quantity;
}
