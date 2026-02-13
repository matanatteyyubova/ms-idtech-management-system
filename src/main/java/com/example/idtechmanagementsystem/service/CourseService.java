package com.example.idtechmanagementsystem.service;

import com.example.idtechmanagementsystem.cache.RedisCacheService;
import com.example.idtechmanagementsystem.dto.request.CreateCourseDto;
import com.example.idtechmanagementsystem.dto.response.CourseDto;
import com.example.idtechmanagementsystem.entity.Course;
import com.example.idtechmanagementsystem.exception.CustomException;
import com.example.idtechmanagementsystem.mapper.CourseMapper;
import com.example.idtechmanagementsystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final RedisCacheService redisCacheService;



    public List<CourseDto> getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map((CourseMapper::mapToCourseDto)).toList();
    };

    public CourseDto createCourse(CreateCourseDto courseDto){
        Course course = CourseMapper.mapToCourse(courseDto);
        Course savedCourse = courseRepository.save(course);
        CourseDto response = CourseMapper.mapToCourseDto(savedCourse);

        redisCacheService.setValue("course:" + response.getId(), response,10);

        return response;
    }

    public CourseDto getCourseById(Long id){
        Object cachedCourse = redisCacheService.getValue("course:" + id);
        if (cachedCourse != null) {
            return (CourseDto) cachedCourse;
        }

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CustomException("Course not found!", "id", HttpStatus.NOT_FOUND));

        CourseDto response = CourseMapper.mapToCourseDto(course);

        redisCacheService.setValue("course:" + id, response,10);

        return response;
    }

    public void updateCourse(CreateCourseDto courseDto) {
        Course course = courseRepository.findById(courseDto.getId())
                .orElseThrow(() -> new CustomException("Course not found!", "id", HttpStatus.NOT_FOUND));

        course.setCourseName(courseDto.getCourseName());
        courseRepository.save(course);

        CourseDto updatedDto = CourseMapper.mapToCourseDto(course);

        redisCacheService.setValue("course:" + updatedDto.getId(), updatedDto,10);
    }

}
