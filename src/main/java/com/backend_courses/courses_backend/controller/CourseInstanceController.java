package com.backend_courses.courses_backend.controller;

import com.backend_courses.courses_backend.CourseInstance;
import com.backend_courses.courses_backend.CourseInstanceDTO;
import com.backend_courses.courses_backend.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    @GetMapping("/dtogetallinstances")
    public List<CourseInstanceDTO> getAllCourseInstances() {
        return courseInstanceService.getAllCourseInstances();
    }

    @PostMapping("/instances")
    public String createInstace(@RequestBody CourseInstance cInstance) {
        return courseInstanceService.saveCourseInstance(cInstance);
    }

    // GET /api/instances/2020/1

  
    @Transactional
    @DeleteMapping("/instances/{year}/{semester}/{courseId}")
    public ResponseEntity<String> deleteCourseInstanceByCourseId(
            @PathVariable int year, @PathVariable int semester, @PathVariable Long courseId) {
        String response = courseInstanceService.deleteCourseInstanceByCourseId(year, semester, courseId);
        return ResponseEntity.ok(response);
    }

   
    @GetMapping("/instances/{year}/{semester}/{courseId}")
    public ResponseEntity<CourseInstanceDTO> getCourseInstanceByYearSemId(
            @PathVariable int year, @PathVariable int semester, @PathVariable Long courseId) {
        CourseInstanceDTO instance = courseInstanceService.getCourseInstanceByYearSemId(year, semester, courseId);
        return ResponseEntity.ok(instance);
    }

    @GetMapping("/instances/{year}/{semester}")
    public ResponseEntity<List<CourseInstanceDTO>> getCourseInstancesByYearSem(
            @PathVariable int year,
            @PathVariable int semester) {
        List<CourseInstanceDTO> instances = courseInstanceService.getCourseInstancesByYearSem(year, semester);
        return ResponseEntity.ok(instances);
    }

}
