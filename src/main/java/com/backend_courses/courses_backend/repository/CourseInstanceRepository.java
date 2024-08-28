package com.backend_courses.courses_backend.repository;

import com.backend_courses.courses_backend.model.CourseInstanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstanceModel, Long> {

    CourseInstanceModel findByYearAndSemesterAndCourseId(int year, int semester, Long courseId);

    List<CourseInstanceModel> findByYearAndSemester(int year, int semester);

    void deleteByYearAndSemesterAndCourseId(int year, int semester, Long courseId);

    @Query("SELECT ci FROM CourseInstanceModel ci JOIN FETCH ci.course")
    List<CourseInstanceModel> findAllWithCourses();

}
