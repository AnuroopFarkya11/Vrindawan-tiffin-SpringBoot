package com.vrindawan.tiffin.repository;

import com.vrindawan.tiffin.model.user.Address;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface AddressRepository extends MongoRepository<Address, ObjectId> {
    boolean existsByaddressId(String id);
}
