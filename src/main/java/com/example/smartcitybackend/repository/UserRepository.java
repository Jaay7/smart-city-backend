package com.example.smartcitybackend.repository;

import com.example.smartcitybackend.model.User;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

  User findOneById(ObjectId id);

  User findByEmail(String email, String password);
  
}
