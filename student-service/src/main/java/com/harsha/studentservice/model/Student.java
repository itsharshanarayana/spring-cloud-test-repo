package com.harsha.studentservice.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
@ToString
public class Student {

    @Id
    @GeneratedValue
    @Column(name="student_id")
    private Long studentId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    public Student(){ }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getStudentId() {
        return studentId;
    }

/*    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }*/

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
}
