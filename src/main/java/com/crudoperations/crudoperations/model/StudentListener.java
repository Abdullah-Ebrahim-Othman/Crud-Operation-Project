package com.crudoperations.crudoperations.model;

import com.crudoperations.crudoperations.repository.mongo.StudentMongoRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentListener {

    @Autowired
    private StudentMongoRepository mongoRepository;

    @PreRemove
    public void beforeDelete(Student student) {
        System.out.println("Deleting Student from PostgresDB: " + student);
        // Transfer the student to MongoDB before deletion
        ArchivedStudent archivedStudent = new ArchivedStudent(student);
        mongoRepository.save(archivedStudent);
    }

    @PostUpdate
    public void afterUpdate(Student student) {
        System.out.println("Updating Student in MongoDB: " + student);
        // Save updated student details in MongoDB
        ArchivedStudent archivedStudent = new ArchivedStudent(student);
        mongoRepository.save(archivedStudent);
    }
}

