package com.vrindawan.tiffin.repository;

import com.vrindawan.tiffin.model.food.FoodEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends MongoRepository<FoodEntity, ObjectId> {

    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    public List<FoodEntity> searchByname(String name);
    public void deleteByname(String name);
    public boolean existsByname(String name);
}
