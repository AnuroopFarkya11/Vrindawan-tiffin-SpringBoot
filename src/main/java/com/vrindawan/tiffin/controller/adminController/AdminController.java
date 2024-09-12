package com.vrindawan.tiffin.controller.adminController;

import com.vrindawan.tiffin.dto.UserDTO;
import com.vrindawan.tiffin.service.UserAuthService;
import com.vrindawan.tiffin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<?> getUsers() {
        log.info("Attempting to fetch list of users");
        List<UserDTO> userDTOList = userService.fetchAllUsers();
        log.info("Fetched user successfully. There are {} users", userDTOList.size());

        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }


}
