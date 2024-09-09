package com.vrindawan.tiffin.repository;

import com.vrindawan.tiffin.model.user.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity,String> {
    @Query("{ 'number' : ?0 }")
    Optional<UserEntity> findByNumber(Long number);
    boolean existsBynumber(Long number);
}
