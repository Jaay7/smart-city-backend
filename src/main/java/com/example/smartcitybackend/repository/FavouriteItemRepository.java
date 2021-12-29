package com.example.smartcitybackend.repository;


import com.example.smartcitybackend.model.FavouriteItems;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FavouriteItemRepository extends MongoRepository<FavouriteItems, String> {
  
  FavouriteItems findOneById(ObjectId id);

  @Query("{ 'category' : ?0 }")
  FavouriteItems findByCategory(String category);

  @Query("{ 'itemId' : ?0 }")
  FavouriteItems findByItemId(String itemId);

  @Query("{ 'userId' : ?0 }")
  Iterable<FavouriteItems> findByUserId(String userId);

  @Query("{ 'itemName' : ?0 }")
  FavouriteItems findByItemName(String itemName);
}
