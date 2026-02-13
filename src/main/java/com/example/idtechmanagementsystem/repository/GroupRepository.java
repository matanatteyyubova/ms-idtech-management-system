package com.example.idtechmanagementsystem.repository;

import com.example.idtechmanagementsystem.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findAllByCourseId(Long courseId);
}
