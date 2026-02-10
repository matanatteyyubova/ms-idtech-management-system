package com.example.idtechmsorders.dto;

import com.example.idtechmsorders.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TeacherDto {
    private Long id;
    private String firstName;
    private String lastName;

}
