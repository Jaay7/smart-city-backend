package com.example.smartcitybackend.model;

import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobs")
public class Job {
  @Id
  private String id;
  private String name;
  private String jobType;
  private List<String> description = new ArrayList<String>();
  private String minSalary;
  private String designation;
  private String qualifications;
  private List<String> requirements = new ArrayList<String>();
  private String lastDate;
  private String startDate;
  private List<String> benefits = new ArrayList<String>();
  private List<String> eligibility = new ArrayList<String>();

  public Job() {}

  public Job(String id, String name, String jobType, List<String> description, String minSalary, String designation,
      String qualifications, List<String> requirements, String lastDate, String startDate, List<String> benefits,
      List<String> eligibility) {
    this.id = id;
    this.name = name;
    this.jobType = jobType;
    this.description = description;
    this.minSalary = minSalary;
    this.designation = designation;
    this.qualifications = qualifications;
    this.requirements = requirements;
    this.lastDate = lastDate;
    this.startDate = startDate;
    this.benefits = benefits;
    this.eligibility = eligibility;
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

  public String getJobType() {
    return jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  public List<String> getDescription() {
    return description;
  }

  public void setDescription(List<String> description) {
    this.description = description;
  }

  public String getMinSalary() {
    return minSalary;
  }

  public void setMinSalary(String minSalary) {
    this.minSalary = minSalary;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getQualifications() {
    return qualifications;
  }

  public void setQualifications(String qualifications) {
    this.qualifications = qualifications;
  }

  public List<String> getRequirements() {
    return requirements;
  }

  public void setRequirements(List<String> requirements) {
    this.requirements = requirements;
  }

  public String getLastDate() {
    return lastDate;
  }

  public void setLastDate(String lastDate) {
    this.lastDate = lastDate;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public List<String> getBenefits() {
    return benefits;
  }

  public void setBenefits(List<String> benefits) {
    this.benefits = benefits;
  }

  public List<String> getEligibility() {
    return eligibility;
  }

  public void setEligibility(List<String> eligibility) {
    this.eligibility = eligibility;
  }

  @Override
  public String toString() {
    return "Job [benefits=" + benefits + ", description=" + description + ", designation=" + designation
        + ", eligibility=" + eligibility + ", id=" + id + ", jobType=" + jobType + ", lastDate=" + lastDate
        + ", minSalary=" + minSalary + ", name=" + name + ", qualifications=" + qualifications + ", requirements="
        + requirements + ", startDate=" + startDate + "]";
  }

}
