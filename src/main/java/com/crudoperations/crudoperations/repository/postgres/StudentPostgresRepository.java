package com.crudoperations.crudoperations.repository.postgres;


import com.crudoperations.crudoperations.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPostgresRepository  extends JpaRepository<Student, Integer> {}
