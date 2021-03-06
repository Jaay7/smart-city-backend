package com.example.smartcitybackend.repository;

import java.util.*;

import com.example.smartcitybackend.model.Restaurants;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantsRepository extends MongoRepository<Restaurants, String> {
  
  Restaurants findOneById(ObjectId id);

  @Query("{ 'name' : ?0 }")
  Restaurants findByName(String name);

  @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
  Iterable<Restaurants> find(String val);

  @Query("{ 'tags': { $all: ?0 } }")
  Iterable<Restaurants> findByTags(List<String> tags);

  // Restaurants update
}
