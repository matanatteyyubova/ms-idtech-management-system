package com.example.idtechmanagementsystem.repository;

import com.example.idtechmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByGroups_Id(Long groupsId);
}
