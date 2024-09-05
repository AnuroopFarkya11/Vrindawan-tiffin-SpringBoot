package com.vrindawan.tiffin.controller.foodController;

import com.vrindawan.tiffin.model.food.FoodEntity;
import com.vrindawan.tiffin.repository.FoodRepository;
import com.vrindawan.tiffin.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService service;

    @PostMapping
    public ResponseEntity<?> createFoodEntity(@RequestBody FoodEntity entity) {
        FoodEntity saved = service.createFoodEntity(entity);
        return new ResponseEntity<FoodEntity>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FoodEntity>> getAllFoodEntity() {
        List<FoodEntity> list = service.getAllFoodEntities();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<?> getFoodEntityByName(@PathVariable String name) {
        FoodEntity entity = service.getFoodEntityByName(name);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }


}
