package com.backend_courses.courses_backend.service;

import java.util.List;
import com.backend_courses.courses_backend.CourseInstance;


public interface ICourseInstanceServices {

    public String saveCourseInstance(CourseInstance courseInstance);

    public List<CourseInstance> getAllInstances();

    public List<CourseInstance> getCoursesByYearAndSemester(int year, int semester);

    public CourseInstance InstanceByYearAndSemesterAndCourseId(int year, int semester, Long courseId);

    public boolean deleteCourseInstanceByCourseId(int year, int semester, Long courseId);

}
