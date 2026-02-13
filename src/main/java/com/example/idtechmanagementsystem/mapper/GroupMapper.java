package com.example.idtechmanagementsystem.mapper;

import com.example.idtechmanagementsystem.dto.request.CreateGroupDto;
import com.example.idtechmanagementsystem.dto.response.GroupDto;
import com.example.idtechmanagementsystem.entity.Course;
import com.example.idtechmanagementsystem.entity.Group;
import com.example.idtechmanagementsystem.entity.Teacher;

import static com.example.idtechmanagementsystem.mapper.CourseMapper.mapToCourseDto;
import static com.example.idtechmanagementsystem.mapper.TeacherMapper.mapToTeacherDto;

public class GroupMapper {
    public static GroupDto mapToGroupDto(Group group) {
        return new GroupDto(
                group.getId(),
                group.getGroupName(),
                group.getPrice(),
                mapToTeacherDto (group.getTeacher()),
                mapToCourseDto(group.getCourse())
        );

    };

    public static Group mapToGroup(CreateGroupDto groupDto) {

        Teacher teacher = new Teacher();
        teacher.setId(groupDto.getTeacherId());

        Course course = new Course();
        course.setId(groupDto.getCourseId());

        return Group.builder()
                .groupName(groupDto.getGroupName())
                .price(groupDto.getPrice())
                .teacher(teacher)
                .course(course)
                .build();
    }
}
