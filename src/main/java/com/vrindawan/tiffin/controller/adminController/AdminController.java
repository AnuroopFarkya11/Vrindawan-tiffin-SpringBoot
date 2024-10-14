package com.vrindawan.tiffin.controller.adminController;

import com.vrindawan.tiffin.dto.UserDTO;
import com.vrindawan.tiffin.exception.ExceptionResponse;
import com.vrindawan.tiffin.model.food.FoodEntity;
import com.vrindawan.tiffin.service.FoodService;
import com.vrindawan.tiffin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;

    @GetMapping("/all-users")
    public ResponseEntity<?> getUsers() {
        log.info("Attempting to fetch list of users");
        List<UserDTO> userDTOList = userService.fetchAllUsers();
        log.info("Fetched user successfully. There are {} users", userDTOList.size());

        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @PostMapping("/create-food")
    public ResponseEntity<?> createFoodEntity(@RequestBody List<FoodEntity> entities) {
        List<FoodEntity> savedEntities = new ArrayList<>();
        entities.forEach((entity -> {
            FoodEntity savedEntity = foodService.createFoodEntity(entity);
            savedEntities.add(savedEntity);
        }));

        return new ResponseEntity<List<FoodEntity>>(savedEntities, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteFoodEntityByName(@RequestParam String name) {
        foodService.deleteFoodEntityByName(name);
        final ExceptionResponse response = new ExceptionResponse("Food Item Deleted Successfully", "Item with name : " + name + " has been deleted");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
