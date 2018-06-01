package com.harsha.studentservice.controller;

import com.harsha.studentservice.model.Student;
import com.harsha.studentservice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/v1", method = RequestMethod.GET)
public class StudentController {

    private static final Logger LOGGER = Logger.getLogger("StudentController.class");

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;

        LOGGER.info("Adding dummy data to DB");
        studentService.addStudent(new Student("Bill", "Gates"));
        studentService.addStudent(new Student("Elon", "Musk"));
        studentService.addStudent(new Student("Steve", "Jobs"));
        studentService.addStudent(new Student("Jeff", "Bezos"));
    }

    @RequestMapping(value="/students", method = RequestMethod.GET)
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @RequestMapping(value="/students/{studentId}", method = RequestMethod.GET)
    public Student getStudentById(
            @PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @RequestMapping(value="/add/student", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student s){
        LOGGER.info("Student object: " + s);
        studentService.addStudent(s);

        return s;
    }
}
