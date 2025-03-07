package com.crudoperations.crudoperations.repository.mongo;

import com.crudoperations.crudoperations.model.MongoStudent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMongoRepository  extends MongoRepository<MongoStudent, String> {}
