package com.backend_courses.courses_backend.controller;

import com.backend_courses.courses_backend.model.CourseInstanceModel;
import com.backend_courses.courses_backend.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    @PostMapping("/instances")
    public ResponseEntity<CourseInstanceModel> createCourseInstance(@RequestBody CourseInstanceModel courseInstance) {
        CourseInstanceModel savedInstance = courseInstanceService.saveCourseInstance(courseInstance);
        return savedInstance != null ? ResponseEntity.ok(savedInstance) : ResponseEntity.status(500).build();
    }

    

    // GET /api/instances/2020/1
    @GetMapping("/instances/{year}/{semester}")
    public ResponseEntity<List<CourseInstanceModel>> getCoursesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
        List<CourseInstanceModel> instances = courseInstanceService.getCoursesByYearAndSemester(year, semester);
        return instances.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(instances);
    }

    @GetMapping("/instances/{year}/{semester}/{id}")
    public ResponseEntity<CourseInstanceModel> getCourseInstanceById(@PathVariable int year, @PathVariable int semester, @PathVariable Long id) {
        Optional<CourseInstanceModel> instance = courseInstanceService.getCourseInstanceById(year, semester, id);
        return instance.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    
    @DeleteMapping("/instances/{year}/{semester}/{id}")
    public ResponseEntity<Void> deleteCourseInstanceById(@PathVariable int year, @PathVariable int semester, @PathVariable Long id) {
        if (courseInstanceService.getCourseInstanceById(year, semester, id).isPresent()) {
            courseInstanceService.deleteCourseInstanceById(year, semester, id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


