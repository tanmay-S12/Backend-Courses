package com.backend_courses.courses_backend;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInstance {
    private Long id;
    private int year;
    private int semester;
    private String courseCode;
}
