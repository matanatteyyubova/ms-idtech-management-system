package com.example.idtechmanagementsystem.service;

import com.example.idtechmanagementsystem.dto.request.CreateGroupDto;
import com.example.idtechmanagementsystem.dto.response.GroupDto;
import com.example.idtechmanagementsystem.entity.Course;
import com.example.idtechmanagementsystem.entity.Group;
import com.example.idtechmanagementsystem.entity.Teacher;
import com.example.idtechmanagementsystem.exception.CustomException;
import com.example.idtechmanagementsystem.mapper.GroupMapper;
import com.example.idtechmanagementsystem.repository.CourseRepository;
import com.example.idtechmanagementsystem.repository.GroupRepository;
import com.example.idtechmanagementsystem.repository.TeacherRepository;
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

    public List<GroupDto> getAllGroupsByCourseId(Long courseId) {
        List<Group> groups = groupRepository.findAllByCourseId(courseId);
        return groups.stream()
                .map(GroupMapper::mapToGroupDto).toList();
    }

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
