package com.example.idtechmsorders.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CreateTeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
}
