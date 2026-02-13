package com.example.idtechmanagementsystem.service;

import com.example.idtechmanagementsystem.dto.request.CreateTeacherDto;
import com.example.idtechmanagementsystem.dto.response.TeacherDto;
import com.example.idtechmanagementsystem.entity.Teacher;
import com.example.idtechmanagementsystem.exception.CustomException;
import com.example.idtechmanagementsystem.mapper.TeacherMapper;
import com.example.idtechmanagementsystem.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;


   public TeacherDto createTeacher(CreateTeacherDto request) {
       Teacher teacher = new Teacher();
       teacher.setFirstName(request.getFirstName());
       teacher.setLastName(request.getLastName());
       return TeacherMapper.mapToTeacherDto(teacherRepository.save(teacher));
   }
    public List<TeacherDto> getAllTeachers() {
       List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream()
                .map((TeacherMapper::mapToTeacherDto)).toList();

    }
   public TeacherDto findTeacherById(Long id) {
       Teacher teacher = teacherRepository.findById(id)
               .orElseThrow(() -> new CustomException("Teacher not found", "id", HttpStatus.NOT_FOUND));

       return TeacherMapper.mapToTeacherDto(teacher);
   }

   public Teacher updateTeacher(CreateTeacherDto request) {
       Teacher teacher =  teacherRepository.findById(request.getId())
               .orElseThrow(() -> new CustomException("Teacher not found", "id", HttpStatus.NOT_FOUND));
       teacher.setFirstName(request.getFirstName());
       teacher.setLastName(request.getLastName());

       return teacherRepository.save(teacher);
   }

}
