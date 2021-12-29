package com.example.smartcitybackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "favouriteItems")
public class FavouriteItems {
  @Id
  private String id;
  private String category;
  private String itemId;
  private String userId;
  private String itemName;

  public FavouriteItems() {
  }

  public FavouriteItems(String id, String category, String itemId, String userId, String itemName) {
    this.id = id;
    this.category = category;
    this.itemId = itemId;
    this.userId = userId;
    this.itemName = itemName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }
  
}
