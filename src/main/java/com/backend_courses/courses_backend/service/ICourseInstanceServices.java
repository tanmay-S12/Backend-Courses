package com.backend_courses.courses_backend.service;

import java.util.List;
import java.util.Optional;

import com.backend_courses.courses_backend.model.CourseInstanceModel;

public interface ICourseInstanceServices {

    public CourseInstanceModel saveCourseInstance(CourseInstanceModel courseInstance);

    public List<CourseInstanceModel> getCoursesByYearAndSemester(int year, int semester);

    public Optional<CourseInstanceModel> getCourseInstanceById(int year, int semester, Long id);

    public void deleteCourseInstanceById(int year, int semester, Long id);

}
