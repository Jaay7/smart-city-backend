package com.example.smartcitybackend.model;

import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "touristPlaces")
public class TouristPlaces {
  @Id
  private String id;
  private String tourismName;
  private String phone;
  private String email;
  private String website;
  private String city;
  private String state;
  private String country;
  private String continent;
  private String currency;
  private String language;
  private String timezone;
  private String image;
  private List<String> tourismDescription = new ArrayList<String>();
  private Integer rating;
  private String price;
  private String open;
  private String close;
  private String lat;
  private String lng;
  private String tourismType;
  private String tourismSubType;
  private List<String> tourismTags = new ArrayList<String>();
  private Integer reviewsCount;
  private List<String> photos = new ArrayList<String>();
  private Integer photosCount;

  public TouristPlaces() {
  }

  public TouristPlaces(String id, String tourismName, String phone, String email, String website, String city, String state,
      String country, String continent, String currency, String language, String timezone, String image,
      List<String> tourismDescription, Integer rating, String price, String open, String close, String lat, String lng,
      String tourismType, String tourismSubType, List<String> tourismTags, Integer reviewsCount,
      List<String> photos, Integer photosCount) {
    this.id = id;
    this.tourismName = tourismName;
    this.phone = phone;
    this.email = email;
    this.website = website;
    this.city = city;
    this.state = state;
    this.country = country;
    this.continent = continent;
    this.currency = currency;
    this.language = language;
    this.timezone = timezone;
    this.image = image;
    this.tourismDescription = tourismDescription;
    this.rating = rating;
    this.price = price;
    this.open = open;
    this.close = close;
    this.lat = lat;
    this.lng = lng;
    this.tourismType = tourismType;
    this.tourismSubType = tourismSubType;
    this.tourismTags = tourismTags;
    this.reviewsCount = reviewsCount;
    this.photos = photos;
    this.photosCount = photosCount;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTourismName() {
    return tourismName;
  }

  public void setTourismName(String tourismName) {
    this.tourismName = tourismName;
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

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public List<String> getTourismDescription() {
    return tourismDescription;
  }

  public void setTourismDescription(List<String> tourismDescription) {
    this.tourismDescription = tourismDescription;
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

  public String getTourismType() {
    return tourismType;
  }

  public void setTourismType(String tourismType) {
    this.tourismType = tourismType;
  }

  public String getTourismSubType() {
    return tourismSubType;
  }

  public void setTourismSubType(String tourismSubType) {
    this.tourismSubType = tourismSubType;
  }

  public List<String> getTourismTags() {
    return tourismTags;
  }

  public void setTourismTags(List<String> tourismTags) {
    this.tourismTags = tourismTags;
  }

  public Integer getReviewsCount() {
    return reviewsCount;
  }

  public void setReviewsCount(Integer reviewsCount) {
    this.reviewsCount = reviewsCount;
  }

  public List<String> getPhotos() {
    return photos;
  }

  public void setPhotos(List<String> photos) {
    this.photos = photos;
  }

  public Integer getPhotosCount() {
    return photosCount;
  }

  public void setPhotosCount(Integer photosCount) {
    this.photosCount = photosCount;
  }
 
}
