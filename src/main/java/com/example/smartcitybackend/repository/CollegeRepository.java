package com.example.smartcitybackend.repository;

import com.example.smartcitybackend.model.College;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CollegeRepository extends MongoRepository<College, String> {

  College findOneById(ObjectId objectId);
  
}
