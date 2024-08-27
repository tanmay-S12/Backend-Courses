package com.backend_courses.courses_backend.service;

import com.backend_courses.courses_backend.model.CourseModel;
import com.backend_courses.courses_backend.Course;
import java.util.List;

public interface ICourseService {

    // public String saveCourse(Course course);
    public Course saveCourse(Course course);

    public List<CourseModel> getAllCourses();

    public Course getCourseById(Long id);

    public boolean deleteCourseById(Long id);
}
