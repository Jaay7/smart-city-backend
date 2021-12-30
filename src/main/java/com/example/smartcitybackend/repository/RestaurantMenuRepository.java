package com.example.smartcitybackend.repository;

import java.util.*;

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

  @Query("{ 'itemName': { $regex: ?0, $options: 'i' } }")
  Iterable<RestaurantMenu> find(String val);

  @Query("{ 'itemTags': { $all: ?0 } }")
  Iterable<RestaurantMenu> findByTags(List<String> tags);

  @Query("{ 'itemRestaurantId': ?0, 'itemTags': { $all: ?1 } }")
  Iterable<RestaurantMenu> findByItemTags(String id, List<String> tags);
}
