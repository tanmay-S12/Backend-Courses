package com.backend_courses.courses_backend.service;

import com.backend_courses.courses_backend.model.CourseModel;
import com.backend_courses.courses_backend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    
    public CourseModel saveCourse(CourseModel course) {
        return courseRepository.save(course);
    }

    public List<CourseModel> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<CourseModel> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }
}


