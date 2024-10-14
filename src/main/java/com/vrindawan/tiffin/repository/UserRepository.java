package com.vrindawan.tiffin.repository;

import com.vrindawan.tiffin.model.user.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity,String> {

    Optional<UserEntity> findByphoneNumber(Long phoneNumber);
    Optional<UserEntity> findByname(String name);
    boolean existsByPhoneNumber(Long number);
}
