package com.vrindawan.tiffin.repository;

import com.vrindawan.tiffin.model.food.FoodItem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FoodRepository extends MongoRepository<FoodItem, ObjectId> {

    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    public List<FoodItem> searchByfoodName(String name);
    public void deleteByfoodName(String name);
    public boolean existsByfoodName(String name);
}
