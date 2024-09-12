package com.vrindawan.tiffin.service;

import com.vrindawan.tiffin.controller.userController.exception.UserNotFoundException;
import com.vrindawan.tiffin.dto.UserDTO;
import com.vrindawan.tiffin.controller.userController.exception.UserAlreadyExistsException;
import com.vrindawan.tiffin.model.user.UserEntity;
import com.vrindawan.tiffin.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public UserEntity createUser(UserDTO userDTO) {
        logger.info("Attempting to create user with UID: {}", userDTO.getUid());

        if (userRepository.existsById(userDTO.getUid())) {
            throw new UserAlreadyExistsException("UID already exists.");
        }

        if (userRepository.existsByPhoneNumber(userDTO.getPhoneNumber())) {
            throw new UserAlreadyExistsException("Phone number already exists.");
        }

        UserEntity user = UserEntity.fromDto(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity savedUser = userRepository.save(user);
        logger.info("User created successfully with UID: {}", savedUser.getUid());
        return savedUser;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> fetchAllUsers() {
        logger.info("Fetching all users");
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(UserEntity::toDto).toList();
    }

    @Transactional(readOnly = true)
    public UserDTO fetchUserById(String uid) {
        logger.info("Attempting to fetch user with id : {}", uid);
        Optional<UserEntity> entity = userRepository.findById(uid);
        if (entity.isPresent()) {
            return entity.get().toDto();
        } else {
            logger.warn("No user found with id : {}", uid);
            throw new UserNotFoundException("User with UID " + uid + " not found.");
        }

    }

    public UserDTO fetchUserByNumber(Long number) {
        logger.info("Attempting to fetch user with number : {}", number);
        logger.info("Runtime type : {}", number.getClass().getName());
        Optional<UserEntity> entity = userRepository.findByphoneNumber(number);


        if (entity.isPresent()) {
            return entity.get().toDto();
        } else {
            logger.warn("No user found with number : {}", number);
            throw new UserNotFoundException("User with number " + number + " not found.");
        }

    }

    @Transactional
    public UserDTO updateUser(String uid, UserDTO userDTO) {


        UserEntity existingUser = userRepository.findById(uid).orElseThrow(() -> new UserNotFoundException("User with UID " + uid + " not found."));
        // Update fields
        if (userDTO.getName() != null) {
            existingUser.setName(userDTO.getName());
        }
        if (userDTO.getAddress() != null) {
            existingUser.setAddress(userDTO.getAddress());
        }
        if (userDTO.getPhoneNumber() != null) {
            existingUser.setPhoneNumber(userDTO.getPhoneNumber());
        }
        if (userDTO.getRole() != null) {
            existingUser.setRole(userDTO.getRole());
        }
        existingUser.setUpdatedAt(LocalDateTime.now());

        UserEntity savedEntity = userRepository.save(existingUser);
        logger.info("User with UID: {} updated successfully", uid);
        return savedEntity.toDto();
    }

    @Transactional
    public void deleteUserById(String uid) {
        logger.info("Attempting to delete user with UID: {}", uid);
        if (userRepository.existsById(uid)) {
            userRepository.deleteById(uid);
            logger.info("User deleted successfully with UID: {}", uid);
        } else {
            throw new UserNotFoundException("User with UID " + uid + " not found.");
        }
    }


}
