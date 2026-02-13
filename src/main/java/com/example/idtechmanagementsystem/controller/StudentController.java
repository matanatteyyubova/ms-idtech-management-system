package com.example.idtechmanagementsystem.controller;

import com.example.idtechmanagementsystem.dto.request.CreateStudentDto;
import com.example.idtechmanagementsystem.dto.response.StudentDto;
import com.example.idtechmanagementsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> get(){
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody CreateStudentDto studentDto) {
        StudentDto createdStudent = studentService.createStudent(studentDto);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdStudent.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdStudent);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody CreateStudentDto request) {
        studentService.updateStudent(request);
        return ResponseEntity.ok().build();
    }

}
