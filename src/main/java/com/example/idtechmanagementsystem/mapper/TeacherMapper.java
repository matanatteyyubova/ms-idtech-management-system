package com.example.idtechmanagementsystem.mapper;

import com.example.idtechmanagementsystem.dto.request.CreateTeacherDto;
import com.example.idtechmanagementsystem.dto.response.TeacherDto;
import com.example.idtechmanagementsystem.entity.Teacher;

public class TeacherMapper {
    public static Teacher mapToTeacher(CreateTeacherDto request) {
        return Teacher.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
    }
    public static TeacherDto mapToTeacherDto(Teacher teacher) {
        return new TeacherDto(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName()


        );
    }
}
