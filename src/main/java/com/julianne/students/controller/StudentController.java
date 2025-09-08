package com.julianne.students.controller;

import com.julianne.students.entity.Student;
import com.julianne.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    // get all the students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    // get student by id
    @GetMapping("/student/{id}")
    public List<Student> getStudent(@PathVariable Integer id) {
        Student student = studentRepository.findById(id).get();
        return Collections.singletonList(student);
    }

    // add new student
    @PostMapping("/student/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

    // update a student
    @PutMapping("/student/update/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Integer id,
            @RequestBody Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setLastName(updatedStudent.getLastName());
                    student.setProgram(updatedStudent.getProgram());
                    Student saved = studentRepository.save(student);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
