package com.example.idtechmsorders.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CreateCourseDto {
    private Long id;
    public String courseName;
}
