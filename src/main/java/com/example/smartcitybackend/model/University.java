package com.example.smartcitybackend.model;

import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "universities")
public class University {
  @Id
  private String id;
  private String name;
  private List<String> description = new ArrayList<String>();
  private String contactInfo;
  private String address;
  private List<String> branch = new ArrayList<String>();

  public University() {}

  public University(String id, String name, List<String> description, String contactInfo, String address, List<String> branch) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.contactInfo = contactInfo;
    this.address = address;
    this.branch = branch;
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

  public List<String> getBranch() {
    return branch;
  }

  public void setBranch(List<String> branch) {
    this.branch = branch;
  }

  @Override
  public String toString() {
    return "University [address=" + address + ", branch=" + branch + ", contactInfo=" + contactInfo + ", description="
        + description + ", id=" + id + ", name=" + name + "]";
  }
  
}
