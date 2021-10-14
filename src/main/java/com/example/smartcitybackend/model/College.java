package com.example.smartcitybackend.model;

import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "colleges")
public class College {
  @Id
  private String id;
  private String name;
  private List<String> description = new ArrayList<String>();
  private String contactInfo;
  private String address;
  private List<String> course = new ArrayList<String>();

  public College() {}

  public College(String id, String name, List<String> description, String contactInfo, String address,
      List<String> course) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.contactInfo = contactInfo;
    this.address = address;
    this.course = course;
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

  public List<String> getDescription() {
    return description;
  }

  public void setDescription(List<String> description) {
    this.description = description;
  }

  public String getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(String contactInfo) {
    this.contactInfo = contactInfo;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<String> getCourse() {
    return course;
  }

  public void setCourse(List<String> course) {
    this.course = course;
  }

  @Override
  public String toString() {
    return "College [address=" + address + ", contactInfo=" + contactInfo + ", course=" + course + ", description="
        + description + ", id=" + id + ", name=" + name + "]";
  }
  
}
