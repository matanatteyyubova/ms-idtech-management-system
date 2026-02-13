package com.example.idtechmanagementsystem.mapper;

import com.example.idtechmanagementsystem.dto.request.CreateStudentDto;
import com.example.idtechmanagementsystem.dto.response.StudentDto;
import com.example.idtechmanagementsystem.entity.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getAge()
        );

    };

    public static Student mapToStudent(CreateStudentDto studentDto) {
        return Student.builder()
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .email(studentDto.getEmail())
                .age(studentDto.getAge())
                .build();


    }
}
