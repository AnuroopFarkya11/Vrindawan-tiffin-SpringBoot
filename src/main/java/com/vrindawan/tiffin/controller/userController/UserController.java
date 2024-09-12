package com.vrindawan.tiffin.controller.userController;

import com.vrindawan.tiffin.dto.UserDTO;
import com.vrindawan.tiffin.exception.ExceptionResponse;
import com.vrindawan.tiffin.model.user.UserEntity;
import com.vrindawan.tiffin.service.UserService;
import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@Validated
@Slf4j
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;





    @GetMapping("/id/{uid}")
    public ResponseEntity<?> getUserById(@PathVariable String uid) {
        log.info("Received request to fetch user with UID: {}", uid);
        UserDTO userDTO = service.fetchUserById(uid);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping("/id/{uid}")
    public ResponseEntity<UserDTO> updateUserEntity(@PathVariable String uid, @RequestBody UserDTO userDTO) {
        log.info("Received request to update user with UID : {}", uid);
        UserDTO updatedUserDTO = service.updateUser(uid,userDTO);
        log.info("User with UID: {} updated successfully", uid);
        return new ResponseEntity<>(updatedUserDTO, HttpStatus.OK);
    }

    @DeleteMapping("/id/{uid}")
    public ResponseEntity<ExceptionResponse> removeUser(@PathVariable String uid){
        log.info("Received request to delete user with UID : {}", uid);
        service.deleteUserById(uid);
        return new ResponseEntity<>(new ExceptionResponse("User deleted successfully", "User with UID: " + uid + " was deleted"), HttpStatus.OK);

    }


}
