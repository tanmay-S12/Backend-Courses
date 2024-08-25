package com.backend_courses.courses_backend;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Course {
    private Long id;
    private String title;
    private String courseCode;
    private String description;
}
