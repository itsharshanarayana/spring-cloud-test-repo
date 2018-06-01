package com.harsha.studentserviceweb.controller;

import com.harsha.studentserviceweb.model.Student;
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
public class StudentServiceWebController {

    private static final Logger LOGGER = Logger.getLogger("StudentServiceWebController.class");
    private final String studentResourceUrl = "http://student-service/v1/students";

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod="getStudentDetailsBackup")
    @RequestMapping(path="/studentDetails", params={"studentId"})
    public String getStudentDetails(@RequestParam Long studentId, Model m){
        LOGGER.info("Student Id: " + studentId);
        LOGGER.info("Request URI: " + studentResourceUrl + "/" + studentId);
        Student s = restTemplate.getForObject(studentResourceUrl + "/" + studentId, Student.class);
        LOGGER.info("Student Object: " + s);
        m.addAttribute("student", s);
        return "studentdetails";

    }

    public String getStudentDetailsBackup(@RequestParam Long studentId, Model m){
        Student s = new Student();
        s.setStudentId(studentId);
        m.addAttribute("student", s);
        return "studentdetails";
    }
}
