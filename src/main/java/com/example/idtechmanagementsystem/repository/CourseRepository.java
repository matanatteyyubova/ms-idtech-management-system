package com.example.idtechmanagementsystem.repository;

import com.example.idtechmanagementsystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
