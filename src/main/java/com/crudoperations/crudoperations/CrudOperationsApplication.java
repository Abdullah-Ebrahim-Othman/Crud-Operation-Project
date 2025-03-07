package com.crudoperations.crudoperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.crudoperations.crudoperations.repository.postgres")
@EnableMongoRepositories(basePackages = "com.crudoperations.crudoperations.repository.mongo")

public class CrudOperationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudOperationsApplication.class, args);
    }

}
