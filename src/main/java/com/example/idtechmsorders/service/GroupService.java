package com.example.idtechmsorders.service;

import com.example.idtechmsorders.dto.request.CreateCourseDto;
import com.example.idtechmsorders.dto.request.CreateGroupDto;
import com.example.idtechmsorders.dto.response.CourseDto;
import com.example.idtechmsorders.dto.response.GroupDto;
import com.example.idtechmsorders.entity.Course;
import com.example.idtechmsorders.entity.Group;
import com.example.idtechmsorders.entity.Teacher;
import com.example.idtechmsorders.exception.CustomException;
import com.example.idtechmsorders.mapper.CourseMapper;
import com.example.idtechmsorders.mapper.GroupMapper;
import com.example.idtechmsorders.repository.CourseRepository;
import com.example.idtechmsorders.repository.GroupRepository;
import com.example.idtechmsorders.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public GroupDto createGroup(CreateGroupDto groupDto) {
        Group group = GroupMapper.mapToGroup(groupDto);
        return GroupMapper.mapToGroupDto(groupRepository.save(group));
    };
    public List<GroupDto> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups.stream()
                .map(GroupMapper::mapToGroupDto).toList();
    };

    public GroupDto getGroupById(Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(()-> new CustomException("Group not found!","id", HttpStatus.NOT_FOUND));

        return GroupMapper.mapToGroupDto(group);
    };

    public void updateGroup(CreateGroupDto groupDto) {

        Group group = groupRepository.findById(groupDto.getId())
                .orElseThrow(() -> new CustomException("Group not found!", "id", HttpStatus.NOT_FOUND));


        group.setGroupName(groupDto.getGroupName());
        group.setPrice(groupDto.getPrice());


        Teacher teacher = teacherRepository.findById(groupDto.getTeacherId())
                .orElseThrow(() -> new CustomException("Teacher not found!", "teacherId", HttpStatus.NOT_FOUND));
        group.setTeacher(teacher);


        Course course = courseRepository.findById(groupDto.getCourseId())
                .orElseThrow(() -> new CustomException("Course not found!", "courseId", HttpStatus.NOT_FOUND));
        group.setCourse(course);


        groupRepository.save(group);
    }



}
