package com.example.idtechmsorders.repository;

import com.example.idtechmsorders.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
