package com.example.idtechmsorders.controller;


import com.example.idtechmsorders.dto.request.CreateTeacherDto;
import com.example.idtechmsorders.dto.response.TeacherDto;
import com.example.idtechmsorders.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherDto>> get() {
        return  ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getById(@PathVariable Long id) {
        TeacherDto teacher = teacherService.findTeacherById(id);
        return ResponseEntity.ok(teacher);
    }

    @PostMapping
    public ResponseEntity<TeacherDto> create(@RequestBody CreateTeacherDto request) {

       TeacherDto createdTeacher= teacherService.createTeacher(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTeacher.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdTeacher);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody CreateTeacherDto request) {
        teacherService.updateTeacher(request);
        return ResponseEntity.ok().build();
    }
}
