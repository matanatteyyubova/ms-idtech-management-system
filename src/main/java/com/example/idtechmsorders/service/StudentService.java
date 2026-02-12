package com.example.idtechmsorders.service;

import com.example.idtechmsorders.dto.request.CreateStudentDto;
import com.example.idtechmsorders.dto.response.StudentDto;
import com.example.idtechmsorders.entity.Student;
import com.example.idtechmsorders.exception.CustomException;
import com.example.idtechmsorders.mapper.StudentMapper;
import com.example.idtechmsorders.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {
    private  final StudentRepository studentRepository;

    public StudentDto  createStudent(CreateStudentDto studentDto){
        Student student = StudentMapper.mapToStudent(studentDto);
        return StudentMapper.mapToStudentDto( studentRepository.save(student));
    };

    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
         return students.stream()
                 .map((StudentMapper::mapToStudentDto)).toList();
    };


    public StudentDto getStudentById(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new CustomException("Student not found!" ,"id", HttpStatus.NOT_FOUND));
        return StudentMapper.mapToStudentDto(student);
    }

    public void updateStudent(CreateStudentDto studentDto) {

        Student student = studentRepository.findById(studentDto.getId())
                .orElseThrow(() -> new CustomException("Student not found!", "id", HttpStatus.NOT_FOUND));

        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());

        studentRepository.save(student);
    }



}
