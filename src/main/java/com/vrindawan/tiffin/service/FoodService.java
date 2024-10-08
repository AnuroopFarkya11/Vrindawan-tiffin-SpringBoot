package com.vrindawan.tiffin.service;

import com.vrindawan.tiffin.controller.foodController.exception.FoodNotFoundException;
import com.vrindawan.tiffin.model.food.FoodEntity;
import com.vrindawan.tiffin.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class FoodService {

    @Autowired
    FoodRepository repository;


    @Transactional
    public FoodEntity createFoodEntity(FoodEntity entity) {
        log.info("Attempting to create food entity");
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        FoodEntity savedEntity = repository.save(entity);
        log.info("Food Item create successfully with id : {}", savedEntity.getId());
        return savedEntity;
    }

    @Transactional(readOnly = true)
    public List<FoodEntity> getAllFoodEntities() {
        log.info("Attempting to get list of food entities");
        List<FoodEntity> foodEntityList = repository.findAll();
        log.info("Food entities fetched successfully. {} entities", foodEntityList.size());
        return foodEntityList;

    }

    @Transactional(readOnly = true)
    public List<FoodEntity> getFoodEntityByName(String name) {
        List<FoodEntity> entity = repository.searchByname(name);
        if (!entity.isEmpty()) {
            return entity;
        } else {
            throw new FoodNotFoundException("No Food entity found with " + name);
        }
    }

    public void deleteFoodEntityByName(String name) {
        if (repository.existsByname(name)) {
            repository.deleteByname(name);
        } else {
            throw new FoodNotFoundException("No food entity found with name " + name);
        }
    }


}
