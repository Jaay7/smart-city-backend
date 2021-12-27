package com.example.smartcitybackend.resolver;

import java.util.*;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.smartcitybackend.model.User;
import com.example.smartcitybackend.model.Job;
import com.example.smartcitybackend.model.RestaurantMenu;
import com.example.smartcitybackend.model.Restaurants;
import com.example.smartcitybackend.model.Reviews;
import com.example.smartcitybackend.model.School;
import com.example.smartcitybackend.model.University;
import com.example.smartcitybackend.model.College;
import com.example.smartcitybackend.repository.CollegeRepository;
import com.example.smartcitybackend.repository.JobRepository;
import com.example.smartcitybackend.repository.RestaurantMenuRepository;
import com.example.smartcitybackend.repository.RestaurantsRepository;
import com.example.smartcitybackend.repository.ReviewRepository;
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
  private RestaurantsRepository restaurantsRepository;
  private RestaurantMenuRepository restaurantMenuRepository;
  private ReviewRepository reviewRepository;

  @Autowired
  public Query(UserRepository userRepository, JobRepository jobRepository, SchoolRepository schoolRepository, CollegeRepository collegeRepository, UniversityRepository universityRepository, RestaurantsRepository restaurantsRepository, RestaurantMenuRepository restaurantMenuRepository, ReviewRepository reviewRepository) {
    this.userRepository = userRepository;
    this.jobRepository = jobRepository;
    this.schoolRepository = schoolRepository;
    this.collegeRepository = collegeRepository;
    this.universityRepository = universityRepository;
    this.restaurantsRepository = restaurantsRepository;
    this.restaurantMenuRepository = restaurantMenuRepository;
    this.reviewRepository = reviewRepository;
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

  public Iterable<Restaurants> findAllRestaurants() {
    return restaurantsRepository.findAll();
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

  public Restaurants restaurant(String id) {
    return restaurantsRepository.findOneById(new ObjectId(id));
  }

  public Iterable<School> searchSchools(String val) {
    return schoolRepository.find(val);
  }

  public Iterable<College> searchColleges(String val) {
    return collegeRepository.find(val);
  }

  public Iterable<University> searchUniversities(String val) {
    return universityRepository.find(val);
  }

  public Iterable<Job> searchJobs(String val) {
    return jobRepository.find(val);
  }

  public Iterable<User> searchUsers(String val) {
    return userRepository.find(val);
  }

  public Iterable<Restaurants> searchRestaurants(String val) {
    return restaurantsRepository.find(val);
  }

  public Iterable<RestaurantMenu> getMenu(String id) {
    return restaurantMenuRepository.findByRestaurantId(id);
  }

  public Iterable<Reviews> getReviews(String id) {
    return reviewRepository.findByItemId(id);
  }

  public Iterable<RestaurantMenu> searchRestaurantMenu(String val) {
    return restaurantMenuRepository.find(val);
  }

  public Iterable<RestaurantMenu> getMenuByTags(String id, List<String> tags) {
    return restaurantMenuRepository.findByItemTags(id, tags);
  }

  public Iterable<Restaurants> getRestaurantsByTags(List<String> tags) {
    return restaurantsRepository.findByTags(tags);
  }

}
