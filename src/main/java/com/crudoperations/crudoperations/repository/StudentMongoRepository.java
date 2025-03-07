package com.crudoperations.crudoperations.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMongoRepository  extends MongoRepository<StudentMongoRepository, String> {}
