package com.example.idtechmsorders.service;

import com.example.idtechmsorders.dto.CreateTeacherRequest;
import com.example.idtechmsorders.dto.TeacherDto;
import com.example.idtechmsorders.entity.Teacher;
import com.example.idtechmsorders.mapper.TeacherMapper;
import com.example.idtechmsorders.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;


   public void createTeacher(CreateTeacherRequest request) {
       Teacher teacher = new Teacher();
       teacher.setFirstName(request.getFirstName());
       teacher.setLastName(request.getLastName());
       teacherRepository.save(teacher);
   }
    public List<TeacherDto> getAllTeachers() {
       List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream()
                .map((TeacherMapper::mapToTeacherDto)).toList();

    }
   public TeacherDto findTeacherById(Long id) {
       Teacher teacher = teacherRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Teacher not found! ID: " + id));

       return TeacherMapper.mapToTeacherDto(teacher);
   }

   public Teacher updateTeacher(CreateTeacherRequest request) {
       Teacher teacher =  teacherRepository.findById(request.getId())
               .orElseThrow(() -> new RuntimeException("Teacher not found! ID: " + request.getId()));
       teacher.setFirstName(request.getFirstName());
       teacher.setLastName(request.getLastName());

       return teacherRepository.save(teacher);
   }

}
