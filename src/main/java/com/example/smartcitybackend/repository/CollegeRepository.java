package com.example.smartcitybackend.repository;

import com.example.smartcitybackend.model.College;
import org.springframework.data.mongodb.repository.Query;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CollegeRepository extends MongoRepository<College, String> {

  College findOneById(ObjectId objectId);

  @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
  Iterable<College> find(String val);
  
}
