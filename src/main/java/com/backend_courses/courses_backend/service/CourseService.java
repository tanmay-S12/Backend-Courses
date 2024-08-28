package com.backend_courses.courses_backend.service;

import com.backend_courses.courses_backend.Course;
import com.backend_courses.courses_backend.model.CourseModel;
import com.backend_courses.courses_backend.repository.CourseRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        CourseModel courseModel = new CourseModel();
        BeanUtils.copyProperties(course, courseModel);
        
        
        CourseModel savedCourseModel = courseRepository.save(courseModel);
        
       
        Course savedCourse = new Course();
        BeanUtils.copyProperties(savedCourseModel, savedCourse);
        
        return savedCourse; 
    }

    public List<CourseModel> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) throws EntityNotFoundException {
        CourseModel optionalCourse = courseRepository.findById(id).get();
        Course rescourse = new Course();
        BeanUtils.copyProperties(optionalCourse, rescourse);
        return rescourse;  
    }

    public boolean deleteCourseById(Long id) {
        courseRepository.deleteById(id);
        return true;
    }
}
