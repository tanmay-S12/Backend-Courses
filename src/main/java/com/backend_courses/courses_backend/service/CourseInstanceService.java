package com.backend_courses.courses_backend.service;

import com.backend_courses.courses_backend.model.CourseInstanceModel;
import com.backend_courses.courses_backend.repository.CourseInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseInstanceService {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    // save course instance. Handled if course already exists check in client side.
    public CourseInstanceModel saveCourseInstance(CourseInstanceModel courseInstance) {
        return courseInstanceRepository.save(courseInstance);
    }

    public List<CourseInstanceModel> getCoursesByYearAndSemester(int year, int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }

    public Optional<CourseInstanceModel> getCourseInstanceById(int year, int semester, Long id) {
        return courseInstanceRepository.findByIdAndYearAndSemester(id, year, semester);
    }
    
    public void deleteCourseInstanceById(int year, int semester, Long id) {
        courseInstanceRepository.deleteByIdAndYearAndSemester(id, year, semester);
    }
}


