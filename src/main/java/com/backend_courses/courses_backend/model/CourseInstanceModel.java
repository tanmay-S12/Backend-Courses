package com.backend_courses.courses_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor 
@AllArgsConstructor
public class CourseInstanceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(nullable = false)
    private int year; 
    
    @Column(nullable = false)
    private int semester; 

    @ManyToOne 
    @JoinColumn(name = "course_id", nullable = false) 
    private CourseModel course; 
    }

