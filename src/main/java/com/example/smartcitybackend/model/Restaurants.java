package com.example.smartcitybackend.model;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurants")
public class Restaurants {
  @Id
  private String id;
  private String name;
  private String address;
  private String phone;
  private String email;
  private String website;
  private String image;
  private List<String> description = new ArrayList<String>();
  private Integer rating;
  private String price;
  private String open;
  private String close;
  private String lat;
  private String lng;
  private String type;
  private String cuisine;
  private List<String> tags = new ArrayList<String>();
  private List<Reviews> reviews = new ArrayList<Reviews>();
  private Integer reviewsCount;
  private String photos;
  private Integer photosCount;
  private List<RestaurantMenu> menu = new ArrayList<RestaurantMenu>();
  private Integer menuCount;

  public Restaurants() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public List<String> getDescription() {
    return description;
  }

  public void setDescription(List<String> description) {
    this.description = description;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getOpen() {
    return open;
  }

  public void setOpen(String open) {
    this.open = open;
  }

  public String getClose() {
    return close;
  }

  public void setClose(String close) {
    this.close = close;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getLng() {
    return lng;
  }

  public void setLng(String lng) {
    this.lng = lng;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCuisine() {
    return cuisine;
  }

  public void setCuisine(String cuisine) {
    this.cuisine = cuisine;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public List<Reviews> getReviews() {
    return reviews;
  }

  public void setReviews(List<Reviews> reviews) {
    this.reviews = reviews;
  }

  public Integer getReviewsCount() {
    return reviewsCount;
  }

  public void setReviewsCount(Integer reviewsCount) {
    this.reviewsCount = reviewsCount;
  }

  public String getPhotos() {
    return photos;
  }

  public void setPhotos(String photos) {
    this.photos = photos;
  }

  public Integer getPhotosCount() {
    return photosCount;
  }

  public void setPhotosCount(Integer photosCount) {
    this.photosCount = photosCount;
  }

  public List<RestaurantMenu> getMenu() {
    return menu;
  }

  public void setMenu(List<RestaurantMenu> menu) {
    this.menu = menu;
  }

  public Integer getMenuCount() {
    return menuCount;
  }

  public void setMenuCount(Integer menuCount) {
    this.menuCount = menuCount;
  }
  
}