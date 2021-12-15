package com.example.smartcitybackend.model;

import org.springframework.data.annotation.Id;

public class Reviews {
  @Id
  private String id;
  private String reviewText;
  private String userId;
  private String itemId;
  private String userName;
  private String userImage;
  private String userReviewDate;
  private String userReviewTime;

  public Reviews() {
  }

  public Reviews(String id, String reviewText, String userId, String itemId, String userName, String userImage,
      String userReviewDate, String userReviewTime) {
    this.id = id;
    this.reviewText = reviewText;
    this.userId = userId;
    this.itemId = itemId;
    this.userName = userName;
    this.userImage = userImage;
    this.userReviewDate = userReviewDate;
    this.userReviewTime = userReviewTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getReviewText() {
    return reviewText;
  }

  public void setReviewText(String reviewText) {
    this.reviewText = reviewText;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserImage() {
    return userImage;
  }

  public void setUserImage(String userImage) {
    this.userImage = userImage;
  }

  public String getUserReviewDate() {
    return userReviewDate;
  }

  public void setUserReviewDate(String userReviewDate) {
    this.userReviewDate = userReviewDate;
  }

  public String getUserReviewTime() {
    return userReviewTime;
  }

  public void setUserReviewTime(String userReviewTime) {
    this.userReviewTime = userReviewTime;
  }

}
