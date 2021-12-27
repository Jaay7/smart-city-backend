package com.example.smartcitybackend.repository;

import java.util.*;

import org.springframework.data.mongodb.repository.Query;

import com.example.smartcitybackend.model.TouristPlaces;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TouristPlaceRepository extends MongoRepository<TouristPlaces, String> {

  TouristPlaces findOneById(ObjectId objectId);

  @Query("{ 'tourismName' : ?0 }")
  TouristPlaces findByName(String name);

  @Query("{ 'tourismName': { $regex: ?0, $options: 'i' } }")
  Iterable<TouristPlaces> find(String val);

  @Query("{ 'tourismTags': { $all: ?0 } }")
  Iterable<TouristPlaces> findByTags(List<String> tags);

  @Query("{ 'city': { $regex: ?0, $options: 'i' } }")
  Iterable<TouristPlaces> findByCity(String city);

  @Query("{ 'state': ?0 }")
  Iterable<TouristPlaces> findByState(String state);

  @Query("{ 'country': ?0 }")
  Iterable<TouristPlaces> findByCountry(String country);

}
