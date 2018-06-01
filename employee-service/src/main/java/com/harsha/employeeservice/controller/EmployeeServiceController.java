package com.harsha.employeeservice.controller;

import com.harsha.employeeservice.model.Employee;
import com.harsha.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/v1", method=RequestMethod.GET)
public class EmployeeServiceController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value="/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @RequestMapping(value="/employees/{employeeId}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable Long employeeId){
        return employeeService.getEmployee(employeeId);
    }

}
