package com.example.smartcitybackend.model;

import java.util.*;
import org.springframework.data.annotation.Id;

public class RestaurantMenu {
  @Id
  private String id;
  private String itemName;
  private List<String> itemDescription = new ArrayList<String>();
  private String itemPrice;
  private String itemImage;
  private String itemCategory;
  private List<String> itemTags = new ArrayList<String>();
  private String itemRestaurantId;

  public RestaurantMenu() {
  }

  public RestaurantMenu(String itemName, List<String> itemDescription, String itemPrice, String itemImage, String itemCategory, List<String> itemTags, String itemRestaurantId) {
    this.itemName = itemName;
    this.itemDescription = itemDescription;
    this.itemPrice = itemPrice;
    this.itemImage = itemImage;
    this.itemCategory = itemCategory;
    this.itemTags = itemTags;
    this.itemRestaurantId = itemRestaurantId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public List<String> getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(List<String> itemDescription) {
    this.itemDescription = itemDescription;
  }

  public String getItemPrice() {
    return itemPrice;
  }

  public void setItemPrice(String itemPrice) {
    this.itemPrice = itemPrice;
  }

  public String getItemImage() {
    return itemImage;
  }

  public void setItemImage(String itemImage) {
    this.itemImage = itemImage;
  }

  public String getItemCategory() {
    return itemCategory;
  }

  public void setItemCategory(String itemCategory) {
    this.itemCategory = itemCategory;
  }

  public String getItemRestaurantId() {
    return itemRestaurantId;
  }

  public void setItemRestaurantId(String itemRestaurantId) {
    this.itemRestaurantId = itemRestaurantId;
  }

  public List<String> getItemTags() {
    return itemTags;
  }

  public void setItemTags(List<String> itemTags) {
    this.itemTags = itemTags;
  }
  
}
