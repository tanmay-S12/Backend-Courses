package com.backend_courses.courses_backend.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
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

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseInstanceModel> courseInstances = new ArrayList<CourseInstanceModel>();
}

