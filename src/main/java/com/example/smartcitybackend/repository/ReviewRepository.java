package com.example.smartcitybackend.repository;

import com.example.smartcitybackend.model.Reviews;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ReviewRepository extends MongoRepository<Reviews, String> {
  
  Reviews findOneById(ObjectId id);

  @Query("{ 'itemId': ?0 }")
  Iterable<Reviews> findByItemId(String itemId);

  @Query("{ 'itemId': ?0, 'itemRestaurantId': ?1 }")
  Reviews findByItemIdAndRestaurantId(ObjectId itemId, ObjectId restaurantId);

}
