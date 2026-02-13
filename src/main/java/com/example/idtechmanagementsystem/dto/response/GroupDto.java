package com.example.idtechmanagementsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
