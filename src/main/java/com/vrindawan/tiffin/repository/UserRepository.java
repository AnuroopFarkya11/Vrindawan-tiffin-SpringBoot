package com.vrindawan.tiffin.repository;

import com.vrindawan.tiffin.model.user.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity,String> {
    Optional<UserEntity> findBynumber(Long number);
    boolean existsBynumber(Long number);
}
