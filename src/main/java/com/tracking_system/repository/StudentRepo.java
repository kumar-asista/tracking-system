package com.tracking_system.repository;

import com.tracking_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    boolean existsByRegisterno(String registerno);

    Optional<Student> findByRegisterno(String registerno);

}
