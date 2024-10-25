package com.vrindawan.tiffin.repository;

import com.vrindawan.tiffin.model.order.OrderEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface OrderRepository extends MongoRepository<OrderEntity, ObjectId> {
    List<OrderEntity> findByuid(String uid);
    Optional<OrderEntity> findByodrId(String odrId);
}