package com.example.smartcitybackend.resolver;

import java.util.*;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.smartcitybackend.model.College;
import com.example.smartcitybackend.model.Job;
import com.example.smartcitybackend.model.RestaurantMenu;
import com.example.smartcitybackend.model.Restaurants;
import com.example.smartcitybackend.model.Reviews;
import com.example.smartcitybackend.model.School;
import com.example.smartcitybackend.model.University;
import com.example.smartcitybackend.model.User;
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
public class Mutation implements GraphQLMutationResolver {
  private UserRepository userRepository;
  private JobRepository jobRepository;
  private SchoolRepository schoolRepository;
  private CollegeRepository collegeRepository;
  private UniversityRepository universityRepository;
  private RestaurantsRepository restaurantsRepository;
  private RestaurantMenuRepository restaurantMenuRepository;
  private ReviewRepository reviewRepository;

  @Autowired
  public Mutation(UserRepository userRepository, JobRepository jobRepository, SchoolRepository schoolRepository, CollegeRepository collegeRepository, UniversityRepository universityRepository, RestaurantsRepository restaurantsRepository, RestaurantMenuRepository restaurantMenuRepository, ReviewRepository reviewRepository) {
    this.userRepository = userRepository;
    this.jobRepository = jobRepository;
    this.schoolRepository = schoolRepository;
    this.collegeRepository = collegeRepository;
    this.universityRepository = universityRepository;
    this.restaurantsRepository = restaurantsRepository;
    this.restaurantMenuRepository = restaurantMenuRepository;
    this.reviewRepository = reviewRepository;
  }

  public User createUser(String firstName, String lastName, String username, String email, String password) {
    User user = new User();

    User checkUser = userRepository.findByEmail(email, password);
    
    if (checkUser == null) {
      user.setFirstName(firstName);
      user.setLastName(lastName);
      user.setUsername(username);
      user.setEmail(email);
      user.setPassword(password);

      userRepository.save(user);
      return user;
    } else {
      return null;
    }
  }

  public User loginUser(String email, String password) {
    User user = userRepository.findByEmail(email, password);
    if (user != null) {
      if(user.getPassword().equals(password)) {
        return user;
      } else {
        System.out.println("incorrect password!");
        return null;
      }
    } else {
      System.out.println("user not found!");
      return null;
    }
  }

  public String addJob(String name, String jobType, List<String> description, String minSalary, String designation, String qualifications, List<String> requirements, String lastDate, String startDate, List<String> benefits, List<String> eligibility) {
    Job job = new Job();

    Job checkJob = jobRepository.findByName(name);

    if (checkJob == null) {
      job.setName(name);
      job.setJobType(jobType);
      job.setDescription(description);
      job.setMinSalary(minSalary);
      job.setDesignation(designation);
      job.setQualifications(qualifications);
      job.setRequirements(requirements);
      job.setLastDate(lastDate);
      job.setStartDate(startDate);
      job.setBenefits(benefits);
      job.setEligibility(eligibility);
      jobRepository.save(job);

      return "Job successfully added!";
    } else {
      return "Job already exists!";
    }
  }

  public String addSchool(String name, List<String> description, String contactInfo, String address, List<String> standard, String board) {
    School school = new School();

    School checkSchool = schoolRepository.findByName(name);

    if(checkSchool == null) {
      school.setName(name);
      school.setDescription(description);
      school.setContactInfo(contactInfo);
      school.setAddress(address);
      school.setStandard(standard);
      school.setBoard(board);
      schoolRepository.save(school);

      return "school successfully added!";
    } else {
      return "school already exists!";
    }
  }

  public String addCollege(String name, List<String> description, String contactInfo, String address,
  List<String> course) {
    College college = new College();

    College checkCollege = collegeRepository.findByName(name);

    if(checkCollege == null) {
      college.setName(name);
      college.setDescription(description);
      college.setContactInfo(contactInfo);
      college.setAddress(address);
      college.setCourse(course);
      collegeRepository.save(college);

      return "college successfully added!";
    } else {
      return "college already exists!";
    }
  }

  public String addUniversity(String name, List<String> description, String contactInfo, String address, List<String> branch) {
    University university = new University();

    University checkUniversity = universityRepository.findByName(name);

    if (checkUniversity == null) {
      university.setName(name);
      university.setDescription(description);
      university.setContactInfo(contactInfo);
      university.setAddress(address);
      university.setBranch(branch);
      universityRepository.save(university);

      return "university successfully added!";
    } else {
      return "university already exists!";
    }
  }

  public String addRestaurant(String name, String address, String phone, String email, String website, String image, List<String> description, Integer rating, String price, String open, String close, String lat, String lng, String type, String cuisine, List<String> tags, Integer reviewsCount, String photos, Integer photosCount, Integer menuCount ) {

    if (restaurantsRepository.findByName(name) == null) {
      Restaurants restaurant = new Restaurants();

      restaurant.setName(name);
      restaurant.setAddress(address);
      restaurant.setPhone(phone);
      restaurant.setEmail(email);
      restaurant.setWebsite(website);
      restaurant.setImage(image);
      restaurant.setDescription(description);
      restaurant.setRating(rating);
      restaurant.setPrice(price);
      restaurant.setOpen(open);
      restaurant.setClose(close);
      restaurant.setLat(lat);
      restaurant.setLng(lng);
      restaurant.setType(type);
      restaurant.setCuisine(cuisine);
      restaurant.setTags(tags);
      restaurant.setReviewsCount(reviewsCount);
      restaurant.setPhotos(photos);
      restaurant.setPhotosCount(photosCount);
      restaurant.setMenuCount(menuCount);
      restaurantsRepository.save(restaurant);
      return "Restaurant successfully added!";
    } else {
      return "Restaurant already exists!";
    }
  }

  public String addRestaurantMenu(String itemName, List<String> itemDescription, String itemPrice, String itemImage, String itemCategory, String itemRestaurantId) {
    RestaurantMenu restaurantMenu = new RestaurantMenu();

    RestaurantMenu checkRestaurantMenuById = restaurantMenuRepository.findByItemId(new ObjectId(itemRestaurantId));
    RestaurantMenu checkRestaurantMenuByName = restaurantMenuRepository.findByItemName(itemName);

    if (checkRestaurantMenuById == null) {
      if (checkRestaurantMenuByName == null) {
        restaurantMenu.setItemName(itemName);
        restaurantMenu.setItemDescription(itemDescription);
        restaurantMenu.setItemPrice(itemPrice);
        restaurantMenu.setItemImage(itemImage);
        restaurantMenu.setItemCategory(itemCategory);
        restaurantMenu.setItemRestaurantId(itemRestaurantId);
        restaurantMenuRepository.save(restaurantMenu);

        return "Menu successfully added!";
      } else {
        return "Menu already exists!";
      }
    } else {
      return "Restaurant doesn't exist!";
    }
  }
  
  public String addReview(String reviewText, String userId, String itemId, String username, String userImage, String userReviewDate, String userReviewTime) {
    Reviews reviews = new Reviews();

    User checkUser = userRepository.findOneById(new ObjectId(userId));
    Restaurants checkRestaurant = restaurantsRepository.findOneById(new ObjectId(itemId));

    if (checkUser != null && checkRestaurant != null) {
      reviews.setReviewText(reviewText);
      reviews.setUserId(userId);
      reviews.setItemId(itemId);
      reviews.setUserName(username);
      reviews.setUserImage(userImage);
      reviews.setUserReviewDate(userReviewDate);
      reviews.setUserReviewTime(userReviewTime);
      reviewRepository.save(reviews);

      return "Review successfully added!";
    } else {
      return "User or Restaurant doesn't exist!";
    }
  }

}
