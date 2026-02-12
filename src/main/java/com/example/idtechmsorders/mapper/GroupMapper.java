package com.example.idtechmsorders.mapper;

import com.example.idtechmsorders.dto.request.CreateGroupDto;
import com.example.idtechmsorders.dto.response.GroupDto;
import com.example.idtechmsorders.entity.Course;
import com.example.idtechmsorders.entity.Group;
import com.example.idtechmsorders.entity.Teacher;

import static com.example.idtechmsorders.mapper.CourseMapper.mapToCourseDto;
import static com.example.idtechmsorders.mapper.TeacherMapper.mapToTeacherDto;

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
