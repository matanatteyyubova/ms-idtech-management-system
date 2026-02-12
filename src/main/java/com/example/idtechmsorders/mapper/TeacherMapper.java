package com.example.idtechmsorders.mapper;

import com.example.idtechmsorders.dto.request.CreateTeacherDto;
import com.example.idtechmsorders.dto.response.TeacherDto;
import com.example.idtechmsorders.entity.Teacher;

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
