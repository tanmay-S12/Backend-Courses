package com.backend_courses.courses_backend.controller;

import com.backend_courses.courses_backend.Course;
import com.backend_courses.courses_backend.model.CourseModel;
import com.backend_courses.courses_backend.service.CourseService;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@Data
@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/courses")
    public String createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseModel>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public Optional<CourseModel> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCourseById(@PathVariable Long id) {
        return courseService.deleteCourseById(id);
    }

}
