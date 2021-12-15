package com.example.smartcitybackend.repository;

import com.example.smartcitybackend.model.University;
import org.springframework.data.mongodb.repository.Query;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UniversityRepository extends MongoRepository<University, String> {

  University findOneById(ObjectId objectId);
  
  @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
  Iterable<University> find(String val);

  @Query("{ name: ?0 }")
  University findByName(String name);
}
