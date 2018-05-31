package com.harsha.coursesourceconsole.controllers;


import com.harsha.coursesourceconsole.model.Course;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Controller
public class CourseServiceConsoleController {

    private final Logger LOGGER = Logger.getLogger("CourseServiceConsoleController.class");
    private final String courseServiceUrl = "http://course-service/v1/courses";

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod="getCourseDetailsBackup")
    @RequestMapping(path="/courseDetails", params={"id"})
    public String getCourseDetails(@RequestParam Long id, Model m){
        LOGGER.info("Course Id: " + id);
        Course c = restTemplate.getForObject(courseServiceUrl + "/" + id, Course.class);
        LOGGER.info("");
        LOGGER.info("Course Object: " + c);
        m.addAttribute("course", c);
        return "console";
    }

    public String getCourseDetailsBackup(@RequestParam Long id, Model m){
        LOGGER.info("Course Id: " + id);
        Course c = new Course();
        c.setId(id);
        LOGGER.info("");
        LOGGER.info("Course Object: " + c);
        m.addAttribute("course", c);
        return "console";
    }
}
