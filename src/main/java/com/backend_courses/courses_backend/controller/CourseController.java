package com.backend_courses.courses_backend.controller;

import com.backend_courses.courses_backend.Course;
import com.backend_courses.courses_backend.model.CourseModel;
import com.backend_courses.courses_backend.service.CourseService;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseService courseService;



    @PostMapping("/courses")
public ResponseEntity<?> createCourse(@RequestBody Course course) {
    try {
        Course savedCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(savedCourse);
    } catch (DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Course code already exists: " + course.getCourseCode());
    }
}


    @GetMapping("/courses")
    public ResponseEntity<List<CourseModel>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.FOUND);
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/courses/{id}")
    public boolean deleteCourseById(@PathVariable Long id) {
        return courseService.deleteCourseById(id);
    }

}
