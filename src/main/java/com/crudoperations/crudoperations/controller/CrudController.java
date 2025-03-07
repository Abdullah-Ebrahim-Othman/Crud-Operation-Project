package com.crudoperations.crudoperations.controller;

import com.crudoperations.crudoperations.model.PostgresStudent;
import com.crudoperations.crudoperations.service.StutentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CrudController {

    @Autowired
    private StutentService service;

    @GetMapping("/v1/students")
    public List<PostgresStudent> students() {

        return service.getStudents();
    }

    @GetMapping("/v1/student{id}")
    public PostgresStudent student(@PathVariable int id) {

        return service.getStudent(id);
    }

    @PostMapping("/v1/student")
    public PostgresStudent addStudent(@RequestBody PostgresStudent student) {
        service.addStudent(student);
        return service.getStudent(student.getId());
    }

    @PutMapping("/v1/student")
    public PostgresStudent updateStudent(@RequestBody PostgresStudent student) {
        service.updateStudent(student);
        return service.getStudent(student.getId());
    }

    @DeleteMapping("/v1/student/{id}")
    public PostgresStudent deleteStudent(@PathVariable int id) {

        PostgresStudent student = service.getStudent(id);

        service.deleteStudent(id);

        return student;
    }

}
