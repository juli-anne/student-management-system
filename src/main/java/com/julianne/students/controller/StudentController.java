package com.julianne.students.controller;

import com.julianne.students.entity.Student;
import com.julianne.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository StudentRepository;
    // get all the students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = StudentRepository.findAll();
        return students;
    }

    @GetMapping("/student/{id}")
    public List<Student> getStudent(@PathVariable Integer id) {
        Student student = StudentRepository.findById(id).get();
        return Collections.singletonList(student);
    }
}
