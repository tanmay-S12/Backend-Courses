package com.backend_courses.courses_backend.service;

import java.util.List;
import com.backend_courses.courses_backend.CourseInstance;

public interface ICourseInstanceServices {

    public String saveCourseInstance(CourseInstance courseInstance);

    public List<CourseInstance> getAllInstances();

    public List<CourseInstance> getCoursesByYearAndSemester(int year, int semester);

    public CourseInstance InstanceByYearAndSemesterAndCourseCode(int year, int semester, String courseCode);

    public boolean deleteCourseInstanceByCourseCode(int year, int semester, String courseCode);

}
