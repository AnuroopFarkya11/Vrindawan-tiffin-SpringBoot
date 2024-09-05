package com.vrindawan.tiffin.repository;

import com.vrindawan.tiffin.model.food.FoodEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FoodRepository extends MongoRepository<FoodEntity, ObjectId> {

    public Optional<FoodEntity> getByname(String name);

}
