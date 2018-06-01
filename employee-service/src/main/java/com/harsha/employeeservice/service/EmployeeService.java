package com.harsha.employeeservice.service;

import com.harsha.employeeservice.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees;

    public EmployeeService(){
        employees = new ArrayList<>();
        employees.add(new Employee(1L, "Harsha", "Narayana", "TestingTechnologies"));
        employees.add(new Employee(2L, "Suhas", "Narayana", "TestingTechnologies"));
        employees.add(new Employee(3L, "Sumithra", "Harsha", "TestingTechnologies"));
    }


    public List<Employee> getEmployees(){
        return employees;
    }

    public Employee getEmployee(Long employeeId){
        for(Employee employee: employees){
            if(employee.getEmployeeId() == employeeId){
                return employee;
            }
        }

        return null;
    }
}
