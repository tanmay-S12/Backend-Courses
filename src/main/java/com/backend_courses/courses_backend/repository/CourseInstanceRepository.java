package com.backend_courses.courses_backend.repository;

import com.backend_courses.courses_backend.model.CourseInstanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstanceModel, Long> {

    List<CourseInstanceModel> findByYearAndSemester(int year, int semester);

    Optional<CourseInstanceModel> findByYearAndSemesterAndCourseId(int year, int semester, Long courseId);

    // void deleteByIdAndYearAndSemester( int year, int semester, Long courseid);

}
