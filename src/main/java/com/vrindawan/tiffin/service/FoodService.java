package com.vrindawan.tiffin.service;

import com.vrindawan.tiffin.controller.foodController.exception.FoodNotFoundException;
import com.vrindawan.tiffin.model.food.FoodItem;
import com.vrindawan.tiffin.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class FoodService {

    @Autowired
    FoodRepository repository;


    @Transactional
    public FoodItem createFoodItem(FoodItem entity) {
        log.info("Attempting to create food entity");
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        FoodItem savedEntity = repository.save(entity);
        log.info("Food Item create successfully with id : {}", savedEntity.getId());
        return savedEntity;
    }

    @Transactional(readOnly = true)
    public List<FoodItem> getAllFoodItems() {
        log.info("Attempting to get list of food entities");
        List<FoodItem> foodItemList = repository.findAll();
        log.info("Food entities fetched successfully. {} entities", foodItemList.size());
        return foodItemList;

    }

    @Transactional(readOnly = true)
    public List<FoodItem> getFoodItemByName(String name) {
        List<FoodItem> Item = repository.searchByfoodName(name);
        if (!Item.isEmpty()) {
            return Item;
        } else {
            throw new FoodNotFoundException("No Food Item found with " + name);
        }
    }

    public void deleteFoodItemByName(String name) {
        if (repository.existsByfoodName(name)) {
            repository.deleteByfoodName(name);
        } else {
            throw new FoodNotFoundException("No food Item found with name " + name);
        }
    }


}
