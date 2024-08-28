package com.backend_courses.courses_backend.service;

import java.util.List;
import com.backend_courses.courses_backend.CourseInstance;
import com.backend_courses.courses_backend.CourseInstanceDTO;

public interface ICourseInstanceServices {

    public String saveCourseInstance(CourseInstance courseInstance);

    public List<CourseInstanceDTO> getAllCourseInstances();

    public CourseInstanceDTO getCourseInstanceByYearSemId(int year, int semester, Long courseId);

    public List<CourseInstanceDTO> getCourseInstancesByYearSem(int year, int semester);

    
}
