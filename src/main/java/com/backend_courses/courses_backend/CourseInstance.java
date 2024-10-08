package com.backend_courses.courses_backend;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInstance {
    // Instance ID 
    private Long id;
    private int year;
    private int semester;
    // Parent course ID
    private Long course;
    
   
    private String title;
    private String courseCode;
    private String description; 
   
}
