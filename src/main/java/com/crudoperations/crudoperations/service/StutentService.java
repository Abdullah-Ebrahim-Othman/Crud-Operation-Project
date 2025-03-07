package com.crudoperations.crudoperations.service;

import com.crudoperations.crudoperations.model.ArchivedStudent;
import com.crudoperations.crudoperations.model.Student;
import com.crudoperations.crudoperations.repository.mongo.StudentMongoRepository;
import com.crudoperations.crudoperations.repository.postgres.StudentPostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StutentService {

    @Autowired
    private StudentPostgresRepository postgresRepository;

    @Autowired
    private StudentMongoRepository mongoRepository;


    public List<Student> geAllSqlStudents() {
        return postgresRepository.findAll();
    }

    public Optional<Student> getStudent(Integer id) {
        return postgresRepository.findById(id);
    }

    public Optional<ArchivedStudent> getArchivedStudent(int id) {
        return mongoRepository.findById(String.valueOf(id));
    }

    public List<ArchivedStudent> getAllArchivedStudents() {
        return mongoRepository.findAll();
    }

    public void addStudent(Student student) {
        postgresRepository.save(student);
    }

    public void updateStudent(Student student) {
        postgresRepository.save(student);
    }


    public void deleteStudent(int id) {
        postgresRepository.deleteById(id);
    }

}
