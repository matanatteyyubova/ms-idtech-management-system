package com.example.idtechmsorders.mapper;

import com.example.idtechmsorders.dto.CreateTeacherRequest;
import com.example.idtechmsorders.dto.TeacherDto;
import com.example.idtechmsorders.entity.Teacher;

public class TeacherMapper {
    public static Teacher mapToTeacher(CreateTeacherRequest request) {
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
