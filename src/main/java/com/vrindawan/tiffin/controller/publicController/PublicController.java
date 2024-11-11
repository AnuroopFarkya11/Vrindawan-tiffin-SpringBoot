package com.vrindawan.tiffin.controller.publicController;

import com.vrindawan.tiffin.dto.UserDTO;
import com.vrindawan.tiffin.model.user.UserEntity;
import com.vrindawan.tiffin.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
@Slf4j
public class PublicController {

    @Autowired
    private UserService service;


    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
        log.info("Attempting to create user with details: {}", userDTO);
        UserEntity user = service.createUser(userDTO);
        log.info("User created successfully with UID: {}", user.getUid());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @GetMapping("/darbar")
    public ResponseEntity<?> happyBdayDarbar(){
        return new ResponseEntity<>("Happy Birthday Darbar",HttpStatus.OK);
    }






//    @GetMapping("/{number}")
//    public ResponseEntity<?> getUserByNumber(@PathVariable Long  number) {
//        UserDTO userDTO = service.fetchUserByNumber(number);
//        return new ResponseEntity<>(userDTO, HttpStatus.OK);
//
//    }
}
