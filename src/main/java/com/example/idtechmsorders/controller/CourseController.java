package com.example.idtechmsorders.controller;

import com.example.idtechmsorders.dto.request.CreateCourseDto;
import com.example.idtechmsorders.dto.response.CourseDto;
import com.example.idtechmsorders.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping
    public ResponseEntity<List<CourseDto>> get(){
        return ResponseEntity.ok(courseService.getAllCourses());
    };

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDto> create(@RequestBody CreateCourseDto courseDto){
        CourseDto createdCourse = courseService.createCourse(courseDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdCourse.getId())
                .toUri();


        return ResponseEntity.created(location).body(createdCourse);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody CreateCourseDto courseDto){
        courseService.updateCourse(courseDto);
        return ResponseEntity.ok().build();
    }
}
