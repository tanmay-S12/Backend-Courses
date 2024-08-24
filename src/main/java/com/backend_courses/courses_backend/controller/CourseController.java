package com.backend_courses.courses_backend.controller;

import com.backend_courses.courses_backend.model.CourseModel;
import com.backend_courses.courses_backend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/courses")
    public ResponseEntity<CourseModel> createCourse(@RequestBody CourseModel course) {
        CourseModel savedCourse = courseService.saveCourse(course);
        return savedCourse != null ? ResponseEntity.ok(savedCourse) : ResponseEntity.status(500).build();
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseModel>> getAllCourses() {
        List<CourseModel> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseModel> getCourseById(@PathVariable Long id) {
        Optional<CourseModel> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id) {
        if (courseService.getCourseById(id).isPresent()) {
            courseService.deleteCourseById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
