package com.example.smartcitybackend.model;

import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "schools")
public class School {
  @Id
  private String id;
  private String name;
  private List<String> description = new ArrayList<String>();
  private String contactInfo;
  private String address;
  private List<String> standard = new ArrayList<String>();
  private String board;

  public School() {}

  public School(String id, String name, List<String> description, String contactInfo, String address, List<String> standard, String board) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.contactInfo = contactInfo;
    this.address = address;
    this.standard = standard;
    this.board = board;
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

  public List<String> getStandard() {
    return standard;
  }

  public void setStandard(List<String> standard) {
    this.standard = standard;
  }

  public String getBoard() {
    return board;
  }

  public void setBoard(String board) {
    this.board = board;
  }

  @Override
  public String toString() {
    return "School [address=" + address + ", board=" + board + ", standard=" + standard + ", contactInfo=" + contactInfo
        + ", description=" + description + ", id=" + id + ", name=" + name + "]";
  }

  
}
