package com.example.smartcitybackend.repository;

import com.example.smartcitybackend.model.User;
import org.springframework.data.mongodb.repository.Query;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

  User findOneById(ObjectId id);

  User findByEmail(String email, String password);
  
  @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
  Iterable<User> find(String val);

}
