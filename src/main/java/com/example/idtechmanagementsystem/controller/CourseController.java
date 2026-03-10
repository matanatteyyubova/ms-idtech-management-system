package com.example.idtechmanagementsystem.controller;

import com.example.idtechmanagementsystem.dto.request.CreateCourseDto;
import com.example.idtechmanagementsystem.dto.response.CourseDto;
import com.example.idtechmanagementsystem.dto.response.GroupDto;
import com.example.idtechmanagementsystem.entity.Group;
import com.example.idtechmanagementsystem.service.CourseService;
import com.example.idtechmanagementsystem.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final GroupService groupService;
    @GetMapping
    public ResponseEntity<List<CourseDto>> get(){
        return ResponseEntity.ok(courseService.getAllCourses());
    };

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping("/{id}/groups")
    public ResponseEntity<List<GroupDto>> getGroupsByCourseId(@PathVariable Long id){
        return ResponseEntity.ok(groupService.getAllGroupsByCourseId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
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
