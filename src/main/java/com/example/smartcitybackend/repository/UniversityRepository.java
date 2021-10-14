package com.example.smartcitybackend.repository;

import com.example.smartcitybackend.model.University;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UniversityRepository extends MongoRepository<University, String> {

  University findOneById(ObjectId objectId);
  
}
