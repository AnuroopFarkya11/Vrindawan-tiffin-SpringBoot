package com.vrindawan.tiffin.controller.userController;

import com.vrindawan.tiffin.dto.UserDTO;
import com.vrindawan.tiffin.model.user.UserEntity;
import com.vrindawan.tiffin.service.UserService;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
        logger.info("Attempting to create user with details: {}", userDTO);
        UserEntity user = service.createUser(userDTO);
        logger.info("User created successfully with UID: {}", user.getUid());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


}
