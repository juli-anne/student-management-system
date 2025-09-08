package com.julianne.students.services;

import com.julianne.students.entities.Student;
import com.julianne.students.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // get a student by id
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    // add a new student
    public Student addStudent(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    // update an existing student
    public Student updateStudent(Integer id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setLastName(updatedStudent.getLastName());
                    student.setProgram(updatedStudent.getProgram());
                    return studentRepository.save(student);
                })
                .orElse(null);
    }

    // delete a student
    public boolean deleteStudent(Integer id) {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student);
                    return true;
                })
                .orElse(false);
    }
}
