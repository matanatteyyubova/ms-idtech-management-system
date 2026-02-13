package com.example.idtechmanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CreateGroupDto {
    private Long id;
    private String groupName;
    private Double price;
    private Long teacherId;
    private Long courseId;
}
