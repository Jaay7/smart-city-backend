package com.example.smartcitybackend.resolver;

import java.util.regex.Pattern;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.smartcitybackend.model.User;
import com.example.smartcitybackend.model.Job;
import com.example.smartcitybackend.model.School;
import com.example.smartcitybackend.model.University;
import com.example.smartcitybackend.model.College;
import com.example.smartcitybackend.repository.CollegeRepository;
import com.example.smartcitybackend.repository.JobRepository;
import com.example.smartcitybackend.repository.SchoolRepository;
import com.example.smartcitybackend.repository.UniversityRepository;
import com.example.smartcitybackend.repository.UserRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
  private UserRepository userRepository;
  private JobRepository jobRepository;
  private SchoolRepository schoolRepository;
  private CollegeRepository collegeRepository;
  private UniversityRepository universityRepository;

  @Autowired
  public Query(UserRepository userRepository, JobRepository jobRepository, SchoolRepository schoolRepository, CollegeRepository collegeRepository, UniversityRepository universityRepository) {
    this.userRepository = userRepository;
    this.jobRepository = jobRepository;
    this.schoolRepository = schoolRepository;
    this.collegeRepository = collegeRepository;
    this.universityRepository = universityRepository;
  }

  public Iterable<User> findAllUsers() {
    return userRepository.findAll();
  }

  public Iterable<Job> findAllJobs() {
    return jobRepository.findAll();
  }
  
  public Iterable<School> findAllSchools() {
    return schoolRepository.findAll();
  }

  public Iterable<College> findAllColleges() {
    return collegeRepository.findAll();
  }

  public Iterable<University> findAllUniversities() {
    return universityRepository.findAll();
  }

  public User user(String id) {
    return userRepository.findOneById(new ObjectId(id));
  }

  public Job job(String id) {
    return jobRepository.findOneById(new ObjectId(id));
  }

  public School school(String id) {
    return schoolRepository.findOneById(new ObjectId(id));
  }

  public College college(String id) {
    return collegeRepository.findOneById(new ObjectId(id));
  }

  public University university(String id) {
    return universityRepository.findOneById(new ObjectId(id));
  }

  public Iterable<School> searchSchools(String val) {
    return schoolRepository.find(val);
  }

}
