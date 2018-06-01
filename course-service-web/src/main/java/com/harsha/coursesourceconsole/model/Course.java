package com.harsha.coursesourceconsole.model;

import lombok.ToString;

@ToString
public class Course {
    private Long id;
    private String name;
    private String description;
    private int numOfSeats;

    public Course(){

    }

    public Course(Long id, String name, String description, int numOfSeats) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.numOfSeats = numOfSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }
}
