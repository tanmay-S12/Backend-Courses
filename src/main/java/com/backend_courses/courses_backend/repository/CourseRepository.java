package com.backend_courses.courses_backend.repository;

import com.backend_courses.courses_backend.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long> {
    
}