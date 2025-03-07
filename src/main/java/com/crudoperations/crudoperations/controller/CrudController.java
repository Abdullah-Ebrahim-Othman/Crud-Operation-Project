package com.crudoperations.crudoperations.controller;

import com.crudoperations.crudoperations.model.PostgresStudent;
import com.crudoperations.crudoperations.service.StutentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class CrudController {

    @Autowired
    private StutentService service;

    @GetMapping("/v1/students")
    public List<PostgresStudent> students() {

        return service.geAllSqlStudents();
    }

    @GetMapping("/v1/student{id}")
    public Optional<PostgresStudent> student(@PathVariable int id) {

        return service.getStudent(id);
    }

    @PostMapping("/v1/student")
    public Optional<PostgresStudent> addStudent(@RequestBody PostgresStudent student) {
        service.addStudent(student);
        return service.getStudent(student.getId());
    }

    @PutMapping("/v1/student")
    public Optional<PostgresStudent> updateStudent(@RequestBody PostgresStudent student) {
        service.updateStudent(student);
        return service.getStudent(student.getId());
    }

    @DeleteMapping("/v1/student/{id}")
    public Optional<PostgresStudent> deleteStudent(@PathVariable int id) {

        Optional<PostgresStudent> student = service.getStudent(id);

        service.deleteStudent(id);

        return student;
    }

}
