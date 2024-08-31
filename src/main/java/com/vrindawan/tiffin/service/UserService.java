package com.vrindawan.tiffin.service;

import com.vrindawan.tiffin.model.user.UserEntity;
import com.vrindawan.tiffin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;


    public void createUser(UserEntity user) {
        userRepository.save(user);
    }

}
