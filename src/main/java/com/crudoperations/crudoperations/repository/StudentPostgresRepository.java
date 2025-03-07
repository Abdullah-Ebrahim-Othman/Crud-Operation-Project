package com.crudoperations.crudoperations.repository;

import com.crudoperations.crudoperations.model.PostgresStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPostgresRepository  extends JpaRepository<PostgresStudent, Integer> {}
