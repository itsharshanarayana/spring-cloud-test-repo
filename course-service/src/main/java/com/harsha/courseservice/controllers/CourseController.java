package com.harsha.courseservice.controllers;

import com.harsha.courseservice.model.Course;
import com.harsha.courseservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1")
public class CourseController {

/*    private List<Course> courses = Arrays.asList(
            new Course(123L, "java", "Java Course", 25 ),
            new Course(124L, "spring", "Spring Fundamentals Course", 24 ),
            new Course(125L, "javascript", "Java Script Course", 23 )
    );*/

    private List<Course> courses = new ArrayList<>();
    public CourseController(){
        Course course1 = new Course(123L, "java", "Java Course", 25 );
        Course course2 = new Course(124L, "spring", "Spring Fundamentals Course", 24 );
        Course course3 = new Course(125L, "javascript", "Java Script Course", 23 );

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/courses", method=RequestMethod.GET)
    public List<Course> getCourses(){
        return courses;
    }


    private final Logger LOGGER = Logger.getLogger("CourseController.class");

    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.GET)
    public Student getStudentById(
            @PathVariable Long studentId){

        ResponseEntity<Student> response = restTemplate.getForEntity("http://student-service/v1/students/" + studentId, Student.class);
        LOGGER.info("Response object: " + response.toString());
        LOGGER.info("Student object: " + response.getBody());

        return response.getBody();

    }

    @RequestMapping(value="/courses/{courseId}", method = RequestMethod.GET)
    public Course getCourseById(@PathVariable Long courseId){

        Course courseFound = null;

        for (Course course: courses){
            if(course.getId() == courseId){
                courseFound = course;
            }
        }

        return courseFound;

    }
}


