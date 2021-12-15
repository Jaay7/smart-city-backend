package com.example.smartcitybackend.repository;

import com.example.smartcitybackend.model.RestaurantMenu;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RestaurantMenuRepository extends MongoRepository<RestaurantMenu, String> {

  RestaurantMenu findOneById(ObjectId id);
  
  @Query("{ 'itemName': ?0 }")
  RestaurantMenu findByItemName(String itemName);

  @Query("{ 'itemRestaurantId': ?0 }")
  RestaurantMenu findByItemId(ObjectId id);

  @Query("{ 'itemRestaurantId': ?0 }")
  Iterable<RestaurantMenu> findByRestaurantId(String id);
}
