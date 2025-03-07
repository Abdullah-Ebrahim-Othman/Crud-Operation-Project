package com.crudoperations.crudoperations.repository.postgres;

import com.crudoperations.crudoperations.model.PostgresStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPostgresRepository  extends JpaRepository<PostgresStudent, Integer> {}
