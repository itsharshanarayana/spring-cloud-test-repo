package com.harsha.studentservice.services;

import com.harsha.studentservice.model.Student;
import com.harsha.studentservice.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        List<Student> allStudents = new ArrayList<>();
        studentRepository.findAll().forEach(allStudents::add);
        return allStudents;
    }

    public Student addStudent(Student student){
        studentRepository.save(student);

        return student;
    }

    public Student getStudentById(Long studentId){
        for (Student student : studentRepository.findAll()) {
            if(student.getStudentId() == studentId){
                return student;
            }
        }

        return null;
    }
}
