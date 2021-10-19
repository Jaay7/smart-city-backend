package com.example.smartcitybackend.repository;

import com.example.smartcitybackend.model.Job;
import org.springframework.data.mongodb.repository.Query;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String> {

  Job findOneById(ObjectId objectId);
  
  @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
  Iterable<Job> find(String val);
}
