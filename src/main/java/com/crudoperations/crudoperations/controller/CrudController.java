package com.crudoperations.crudoperations.controller;

import com.crudoperations.crudoperations.model.Student;
import com.crudoperations.crudoperations.service.StutentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CrudController {

    @Autowired
    private StutentService service;

    @GetMapping("/v1/students")
    public List<Student> getStudents() {

        return service.geAllSqlStudents();
    }

    @GetMapping("/v1/student{id}")
    public Optional<Student> getStudent(@PathVariable int id) {

        return service.getStudent(id);
    }

    @PostMapping("/v1/student")
    public Optional<Student> addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return service.getStudent(student.getId());
    }

    @PutMapping("/v1/student")
    public Optional<Student> updateStudent(@RequestBody Student student) {
        service.updateStudent(student);
        return service.getStudent(student.getId());
    }

    @DeleteMapping("/v1/student/{id}")
    public Optional<Student> deleteStudent(@PathVariable int id) {

        Optional<Student> student = service.getStudent(id);
        if (student.isPresent()) {
            service.deleteStudent(id);
        }
        return student;
    }
}
