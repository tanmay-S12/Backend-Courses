package com.backend_courses.courses_backend.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Entity
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) 
    private String title;

    @Column(nullable = false, unique = true) 
    private String courseCode;

    @Column(length = 1000) 
    private String description;

}

