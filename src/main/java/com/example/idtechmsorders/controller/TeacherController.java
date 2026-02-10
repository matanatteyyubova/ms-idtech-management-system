package com.example.idtechmsorders.controller;


import com.example.idtechmsorders.dto.CreateTeacherRequest;
import com.example.idtechmsorders.dto.TeacherDto;
import com.example.idtechmsorders.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherDto getTeacherById(@PathVariable Long id) {
        return teacherService.findTeacherById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeacher(@RequestBody CreateTeacherRequest request) {
        teacherService.createTeacher(request);
    }

    @PutMapping
    public void updateTeacher(@RequestBody CreateTeacherRequest request) {
        teacherService.updateTeacher(request);
    }
}
