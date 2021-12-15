package com.example.smartcitybackend.repository;


import com.example.smartcitybackend.model.School;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SchoolRepository extends MongoRepository<School, String> {

  School findOneById(ObjectId objectId);

  // Iterable<School> findAllByName(String text);

  @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
  Iterable<School> find(String val);

  @Query("{ name: ?0 }")
  School findByName(String name);

  // List<School> find(Query query, Class<School> class1);

  // School findAll(String text);
  
}
