package com.example.idtechmanagementsystem.mapper;

import com.example.idtechmanagementsystem.dto.request.CreateCourseDto;
import com.example.idtechmanagementsystem.dto.response.CourseDto;
import com.example.idtechmanagementsystem.entity.Course;

public class CourseMapper {
    public static Course mapToCourse(CreateCourseDto courseDto){
        return  Course.builder()
                .courseName(courseDto.getCourseName())
                .build();
    }

    public static CourseDto mapToCourseDto(Course course){

        return new CourseDto(
                course.getId(),
                course.getCourseName()
        );
    }
}
