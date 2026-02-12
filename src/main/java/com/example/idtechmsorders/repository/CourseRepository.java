package com.example.idtechmsorders.repository;

import com.example.idtechmsorders.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
