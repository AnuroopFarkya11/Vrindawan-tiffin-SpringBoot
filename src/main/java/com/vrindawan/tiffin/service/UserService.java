package com.vrindawan.tiffin.service;

import com.vrindawan.tiffin.dto.UserDTO;
import com.vrindawan.tiffin.exception.UserAlreadyExistsException;
import com.vrindawan.tiffin.model.user.UserEntity;
import com.vrindawan.tiffin.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Transactional
    public UserEntity createUser(UserDTO userDTO) {
        logger.info("Attempting to create user with UID: {}", userDTO.getUid());

        if (userRepository.existsById(userDTO.getUid())) {
            throw new UserAlreadyExistsException("User with UID " + userDTO.getUid() + " already exists.");
        }
        UserEntity user = UserEntity.fromDto(userDTO);

        UserEntity savedUser = userRepository.save(user);
        logger.info("User created successfully with UID: {}", savedUser.getUid());
        return savedUser;
    }

}
