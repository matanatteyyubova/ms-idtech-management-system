package com.example.idtechmsorders.dto.response;

import com.example.idtechmsorders.entity.Course;
import com.example.idtechmsorders.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GroupDto {
    private Long id;
    private String groupName;
    private Double price;
    private TeacherDto teacher;
    private CourseDto course;


}
