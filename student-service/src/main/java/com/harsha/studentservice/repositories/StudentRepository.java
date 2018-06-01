package com.harsha.studentservice.repositories;

import com.harsha.studentservice.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    /*tudent findStudentById(Long id);*/

}
