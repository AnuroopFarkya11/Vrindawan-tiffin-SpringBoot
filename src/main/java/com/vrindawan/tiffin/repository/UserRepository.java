package com.vrindawan.tiffin.repository;

import com.vrindawan.tiffin.model.user.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity,String> {
}
