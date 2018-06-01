package com.harsha.studentserviceweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
public class StudentServiceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceWebApplication.class, args);
    }
}
