package com.example.idtechmsorders.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CreateTeacherRequest {
    private Long id;
    private String firstName;
    private String lastName;
}
