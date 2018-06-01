package com.harsha.employeeserviceweb.controller;

import com.harsha.employeeserviceweb.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@RibbonClient(name="employee-service")
@Controller
@EnableEurekaClient
public class EmployeeServiceWebController {

    private final String employeeResourceUrl = "http://employee-service/v1/employees";

    @Autowired
    private RestTemplate restTemplate;

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @RequestMapping(path="/employeeDetails", params={"employeeId"})
    public String getEmployee(@RequestParam Long employeeId, Model model){
        Employee e = restTemplate.getForObject(employeeResourceUrl + "/" + employeeId, Employee.class);
        model.addAttribute("employee", e);
        return "employee_view";
    }

}
