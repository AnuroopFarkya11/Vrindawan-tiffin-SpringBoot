package com.vrindawan.tiffin.controller;

import com.vrindawan.tiffin.model.user.UserEntity;
import com.vrindawan.tiffin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserEntity user) {
        try {
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());
            service.createUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NO_CONTENT);
        }

    }

}
