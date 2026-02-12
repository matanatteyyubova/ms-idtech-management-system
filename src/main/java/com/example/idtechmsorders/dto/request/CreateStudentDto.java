package com.example.idtechmsorders.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CreateStudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long age;
}
