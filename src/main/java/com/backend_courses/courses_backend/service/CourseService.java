package com.backend_courses.courses_backend.service;

import com.backend_courses.courses_backend.Course;
import com.backend_courses.courses_backend.model.CourseModel;
import com.backend_courses.courses_backend.repository.CourseRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class CourseService implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;

    
    public String saveCourse(Course course) {
        CourseModel coursemodel = new CourseModel();
        BeanUtils.copyProperties(course, coursemodel);
        courseRepository.save(coursemodel);
        return "Course Saved Succesfully";
    }
  
  
    public List<CourseModel> getAllCourses(){
    return courseRepository.findAll();
    }

    // public CourseModel getCourseById(Long id) {
    //   return courseRepository.findById(id);
    // }
    public Optional<CourseModel> getCourseById(Long id){
        return courseRepository.findById(id);
    }

    public boolean deleteCourseById(Long id) {
        courseRepository.deleteById(id);
        return true;
    }
}


