package com.example.idtechmsorders.mapper;

import com.example.idtechmsorders.dto.request.CreateCourseDto;
import com.example.idtechmsorders.dto.response.CourseDto;
import com.example.idtechmsorders.entity.Course;

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
