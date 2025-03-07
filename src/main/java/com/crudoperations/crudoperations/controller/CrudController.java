package com.crudoperations.crudoperations.controller;

import com.crudoperations.crudoperations.model.ArchivedStudent;
import com.crudoperations.crudoperations.model.Student;
import com.crudoperations.crudoperations.service.StutentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CrudController {

    @Autowired
    private StutentService service;

    @GetMapping("/archivedStudents")
    public ResponseEntity<List<ArchivedStudent>> getArchivedStudent() {
        List<ArchivedStudent> students = service.getAllArchivedStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = service.geAllSqlStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/student/{id}") // ✅ FIXED PATH VARIABLE SYNTAX
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        return service.getStudent(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // ✅ Return 404 if student not found
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> existingStudentOptional = service.getStudent(id);

        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();

            // Update only non-null fields
            if (student.getName() != null) existingStudent.setName(student.getName());
            if (student.getLevel() != null) existingStudent.setLevel(student.getLevel());
            if (student.getGpa() != 0) existingStudent.setGpa(student.getGpa());
            if (student.getAge() != 0) existingStudent.setAge(student.getAge());
            if (student.getGender() != null) existingStudent.setGender(student.getGender());
            if (student.getAddress() != null) existingStudent.setAddress(student.getAddress());
            if (student.getPhone() != null) existingStudent.setPhone(student.getPhone());

            // Save the updated entity
            Student updatedStudent = service.updateStudent(existingStudent);
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> student = service.getStudent(id);
        if (student.isPresent()) {
            service.deleteStudent(id);
            return ResponseEntity.ok("Student deleted successfully");
        }
        return ResponseEntity.notFound().build(); // ✅ Return 404 if student doesn't exist
    }
}
