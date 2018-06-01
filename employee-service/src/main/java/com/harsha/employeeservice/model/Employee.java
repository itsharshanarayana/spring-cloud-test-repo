package com.harsha.employeeservice.model;

public class Employee {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String company;

    public Employee(){

    }

    public Employee(Long employeeId, String firstName, String lastName, String company) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

