package com.backend_courses.courses_backend.controller;

import com.backend_courses.courses_backend.CourseInstance;
import com.backend_courses.courses_backend.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    @PostMapping("/instances")
    public String createInstace(@RequestBody CourseInstance cInstance) {
        return courseInstanceService.saveCourseInstance(cInstance);
    }

    @GetMapping("/allinstances")
    public ResponseEntity<List<CourseInstance>> getAllInstances() {
        
        List<CourseInstance> courses = courseInstanceService.getAllInstances();

        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(courses);
    }

    // GET /api/instances/2020/1
    @GetMapping("/instances/{year}/{semester}")
    public ResponseEntity<List<CourseInstance>> getCoursesByYearAndSemester(
            @PathVariable int year,
            @PathVariable int semester) {
        List<CourseInstance> courses = courseInstanceService.getCoursesByYearAndSemester(year, semester);

        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courses);
    }

    // @GetMapping("/instances/{year}/{semester}/{courseid}")
    @GetMapping("/instances/{year}/{semester}/{courseId}")
    public ResponseEntity<CourseInstance> InstanceByYearAndSemesterAndId(
            @PathVariable int year, @PathVariable int semester, @PathVariable String courseCode) {
        CourseInstance courseInstance = courseInstanceService.InstanceByYearAndSemesterAndCourseCode(year, semester,
                courseCode);
        if (courseInstance == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(courseInstance);
    }

    // @DeleteMapping("/instances/{year}/{semester}/{courseid}")

    @DeleteMapping("/instances/{year}/{semester}/{courseId}")
    public ResponseEntity<String> deleteCourseInstance(@PathVariable int year, @PathVariable int semester,
            @PathVariable String courseCode) {
        boolean isDeleted = courseInstanceService.deleteCourseInstanceByCourseCode(year, semester, courseCode);

        if (isDeleted) {
            return ResponseEntity.ok("Course instance deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course instance not found.");
        }
    }

}
