package com.backend_courses.courses_backend.repository;

import com.backend_courses.courses_backend.model.CourseInstanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstanceModel, Long> {
    List<CourseInstanceModel> findByYearAndSemester(int year, int semester);

    Optional<CourseInstanceModel> findByIdAndYearAndSemester(Long id, int year, int semester);
    
    void deleteByIdAndYearAndSemester(Long id, int year, int semester);
}
