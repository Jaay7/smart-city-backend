package com.example.smartcitybackend.resolver;

import java.util.*;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.smartcitybackend.model.College;
import com.example.smartcitybackend.model.Job;
import com.example.smartcitybackend.model.School;
import com.example.smartcitybackend.model.University;
import com.example.smartcitybackend.model.User;
import com.example.smartcitybackend.repository.CollegeRepository;
import com.example.smartcitybackend.repository.JobRepository;
import com.example.smartcitybackend.repository.SchoolRepository;
import com.example.smartcitybackend.repository.UniversityRepository;
import com.example.smartcitybackend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
  private UserRepository userRepository;
  private JobRepository jobRepository;
  private SchoolRepository schoolRepository;
  private CollegeRepository collegeRepository;
  private UniversityRepository universityRepository;

  @Autowired
  public Mutation(UserRepository userRepository, JobRepository jobRepository, SchoolRepository schoolRepository, CollegeRepository collegeRepository, UniversityRepository universityRepository) {
    this.userRepository = userRepository;
    this.jobRepository = jobRepository;
    this.schoolRepository = schoolRepository;
    this.collegeRepository = collegeRepository;
    this.universityRepository = universityRepository;
  }

  public User createUser(String firstName, String lastName, String username, String email, String password) {
    User user = new User();
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setUsername(username);
    user.setEmail(email);
    user.setPassword(password);

    userRepository.save(user);
    return user;
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
  }

  public String addSchool(String name, List<String> description, String contactInfo, String address, List<String> standard, String board) {
    School school = new School();
    school.setName(name);
    school.setDescription(description);
    school.setContactInfo(contactInfo);
    school.setAddress(address);
    school.setStandard(standard);
    school.setBoard(board);
    schoolRepository.save(school);

    return "school successfully added!";
  }

  public String addCollege(String name, List<String> description, String contactInfo, String address,
  List<String> course) {
    College college = new College();
    college.setName(name);
    college.setDescription(description);
    college.setContactInfo(contactInfo);
    college.setAddress(address);
    college.setCourse(course);
    collegeRepository.save(college);

    return "college successfully added!";
  }

  public String addUniversity(String name, List<String> description, String contactInfo, String address, List<String> branch) {
    University university = new University();
    university.setName(name);
    university.setDescription(description);
    university.setContactInfo(contactInfo);
    university.setAddress(address);
    university.setBranch(branch);
    universityRepository.save(university);

    return "university successfully added!";
  }
}
