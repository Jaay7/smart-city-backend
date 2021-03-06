package com.example.smartcitybackend.resolver;

import java.util.*;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.smartcitybackend.model.College;
import com.example.smartcitybackend.model.FavouriteItems;
import com.example.smartcitybackend.model.Job;
import com.example.smartcitybackend.model.RestaurantMenu;
import com.example.smartcitybackend.model.Restaurants;
import com.example.smartcitybackend.model.Reviews;
import com.example.smartcitybackend.model.School;
import com.example.smartcitybackend.model.TouristPlaces;
import com.example.smartcitybackend.model.University;
import com.example.smartcitybackend.model.User;
import com.example.smartcitybackend.repository.CollegeRepository;
import com.example.smartcitybackend.repository.FavouriteItemRepository;
import com.example.smartcitybackend.repository.JobRepository;
import com.example.smartcitybackend.repository.RestaurantMenuRepository;
import com.example.smartcitybackend.repository.RestaurantsRepository;
import com.example.smartcitybackend.repository.ReviewRepository;
import com.example.smartcitybackend.repository.SchoolRepository;
import com.example.smartcitybackend.repository.TouristPlaceRepository;
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
  private TouristPlaceRepository touristPlaceRepository;
  private FavouriteItemRepository favouriteItemRepository;

  @Autowired
  public Mutation(UserRepository userRepository, JobRepository jobRepository, SchoolRepository schoolRepository, CollegeRepository collegeRepository, UniversityRepository universityRepository, RestaurantsRepository restaurantsRepository, RestaurantMenuRepository restaurantMenuRepository, ReviewRepository reviewRepository, TouristPlaceRepository touristPlaceRepository, FavouriteItemRepository favouriteItemRepository) {
    this.userRepository = userRepository;
    this.jobRepository = jobRepository;
    this.schoolRepository = schoolRepository;
    this.collegeRepository = collegeRepository;
    this.universityRepository = universityRepository;
    this.restaurantsRepository = restaurantsRepository;
    this.restaurantMenuRepository = restaurantMenuRepository;
    this.reviewRepository = reviewRepository;
    this.touristPlaceRepository = touristPlaceRepository;
    this.favouriteItemRepository = favouriteItemRepository;
  }

  public User createUser(String firstName, String lastName, String username, String email, String password, String role, String userType) {
    User user = new User();

    User checkUser = userRepository.findByEmail(email);
    
    if (checkUser == null) {
      user.setFirstName(firstName);
      user.setLastName(lastName);
      user.setUsername(username);
      user.setEmail(email);
      user.setPassword(password);
      user.setRole(role);
      user.setUserType(userType);

      userRepository.save(user);
      return user;
    } else {
      return null;
    }
  }

  public User loginUser(String email, String password) {
    User user = userRepository.findByEmail(email);
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

  public String addRestaurantMenu(String itemName, List<String> itemDescription, String itemPrice, String itemImage, String itemCategory, List<String> itemTags, String itemRestaurantId) {
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
        restaurantMenu.setItemTags(itemTags);
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

  public String addTouristPlace( String tourismName, String phone, String email, String website, String city, String state, String country, 
    String continent, String currency, String language, String timezone, String image, List<String> tourismDescription, Integer rating, 
    String price, String open, String close, String lat, String lng, String tourismType, String tourismSubType, List<String> tourismTags, Integer reviewsCount, List<String> photos, Integer photosCount
  ) {
    if ( touristPlaceRepository.findByName(tourismName) != null) {
      return "Tourist Place already exists!";
    } else {
      TouristPlaces touristPlace = new TouristPlaces();

      touristPlace.setTourismName(tourismName);
      touristPlace.setPhone(phone);
      touristPlace.setEmail(email);
      touristPlace.setWebsite(website);
      touristPlace.setCity(city);
      touristPlace.setState(state);
      touristPlace.setCountry(country);
      touristPlace.setContinent(continent);
      touristPlace.setCurrency(currency);
      touristPlace.setLanguage(language);
      touristPlace.setTimezone(timezone);
      touristPlace.setImage(image);
      touristPlace.setTourismDescription(tourismDescription);
      touristPlace.setRating(rating);
      touristPlace.setPrice(price);
      touristPlace.setOpen(open);
      touristPlace.setClose(close);
      touristPlace.setLat(lat);
      touristPlace.setLng(lng);
      touristPlace.setTourismType(tourismType);
      touristPlace.setTourismSubType(tourismSubType);
      touristPlace.setTourismTags(tourismTags);
      touristPlace.setReviewsCount(reviewsCount);
      touristPlace.setPhotos(photos);
      touristPlace.setPhotosCount(photosCount);
      touristPlaceRepository.save(touristPlace);

      return "Tourist Place successfully added!";
    }
  }

  public String addFavouriteItem(String category, String itemId, String userId, String itemName) {
    FavouriteItems favourite = new FavouriteItems();

    User checkUser = userRepository.findOneById(new ObjectId(userId));
    Restaurants checkRestaurant = restaurantsRepository.findOneById(new ObjectId(itemId));
    School checkSchool = schoolRepository.findOneById(new ObjectId(itemId));
    College checkCollege = collegeRepository.findOneById(new ObjectId(itemId));
    University checkUniversity = universityRepository.findOneById(new ObjectId(itemId));
    TouristPlaces checkTouristPlace = touristPlaceRepository.findOneById(new ObjectId(itemId));
    FavouriteItems checkFavourite = favouriteItemRepository.findByItemId(itemId);

    if (checkUser != null) {
      if (checkFavourite == null) {
        if (checkSchool != null) {
          favourite.setCategory(category);
          favourite.setItemId(itemId);
          favourite.setUserId(userId);
          favourite.setItemName(itemName);
          favouriteItemRepository.save(favourite);

          return "School successfully added!";
        } else if (checkCollege != null) {
          favourite.setCategory(category);
          favourite.setItemId(itemId);
          favourite.setUserId(userId);
          favourite.setItemName(itemName);
          favouriteItemRepository.save(favourite);

          return "College successfully added!";
        } else if (checkUniversity != null) {
          favourite.setCategory(category);
          favourite.setItemId(itemId);
          favourite.setUserId(userId);
          favourite.setItemName(itemName);
          favouriteItemRepository.save(favourite);

          return "University successfully added!";
        } else if (checkRestaurant != null) {
          favourite.setCategory(category);
          favourite.setItemId(itemId);
          favourite.setUserId(userId);
          favourite.setItemName(itemName);
          favouriteItemRepository.save(favourite);

          return "Restaurant successfully added!";
        } else if (checkTouristPlace != null) {
          favourite.setCategory(category);
          favourite.setItemId(itemId);
          favourite.setUserId(userId);
          favourite.setItemName(itemName);
          favouriteItemRepository.save(favourite);

          return "Tourist Place successfully added!";
        } else {
          return "Item doesn't exist!";
        }
      } else {
        return "Item already exists in your favourites!";
      }
    } else {
      return "User doesn't exist!";
    }
  }

}
