package com.crudoperations.crudoperations.service;

import com.crudoperations.crudoperations.model.PostgresStudent;
import com.crudoperations.crudoperations.repository.StudentMongoRepository;
import com.crudoperations.crudoperations.repository.StudentPostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StutentService {

    @Autowired
    private StudentPostgresRepository studentRepository;

    @Autowired
    private StudentMongoRepository studentMongoRepository;


    public List<PostgresStudent> getStudents() {
        return studentRepository.findAll();
    }

    public PostgresStudent getStudent(int id) {
        return studentRepository.getReferenceById(id);
    }

    public void addStudent(PostgresStudent student) {
        studentRepository.save(student);
    }

    public void updateStudent(PostgresStudent student) {
        studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
