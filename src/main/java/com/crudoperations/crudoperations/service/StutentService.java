package com.crudoperations.crudoperations.service;

import com.crudoperations.crudoperations.model.MongoStudent;
import com.crudoperations.crudoperations.model.PostgresStudent;
import com.crudoperations.crudoperations.repository.mongo.StudentMongoRepository;
import com.crudoperations.crudoperations.repository.postgres.StudentPostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StutentService {

    @Autowired
    private StudentPostgresRepository studentSqlRepository;

    @Autowired
    private StudentMongoRepository studentMongoRepository;


    public List<PostgresStudent> geAllSqlStudents() {
        return studentSqlRepository.findAll();
    }

    public List<MongoStudent> getAllMongoStudents() {
        return studentMongoRepository.findAll();
    }

    public Optional<PostgresStudent> getStudent(Integer id) {
        return studentSqlRepository.findById(id);
    }

    public Optional<MongoStudent> getMongoStudent(int id) {
        return studentMongoRepository.findById(String.valueOf(id));
    }

    public void addStudent(PostgresStudent student) {
        studentSqlRepository.save(student);
    }

    public void addStudentInMongo(MongoStudent student) {
        studentMongoRepository.save(student);
    }

    public void updateStudent(PostgresStudent student) {
        studentSqlRepository.save(student);
    }

    public void updateStudentInMongo(MongoStudent student) {
        studentMongoRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentSqlRepository.deleteById(id);
    }

    public void deleteStudentInMongo(int id) {
        studentMongoRepository.deleteById(String.valueOf(id));
    }
}
