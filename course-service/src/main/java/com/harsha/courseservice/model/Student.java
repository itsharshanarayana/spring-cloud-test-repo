package com.harsha.courseservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;

@JsonIgnoreProperties
@ToString
public class Student {

    private Long studentId;
    private String studentName;

    public Student(){

    }

    public Student(Long studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
