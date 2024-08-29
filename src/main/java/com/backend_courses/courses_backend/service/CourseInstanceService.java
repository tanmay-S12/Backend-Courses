package com.backend_courses.courses_backend.service;

import com.backend_courses.courses_backend.CourseInstance;
import com.backend_courses.courses_backend.CourseInstanceDTO;
import com.backend_courses.courses_backend.model.CourseInstanceModel;
import com.backend_courses.courses_backend.model.CourseModel;
import com.backend_courses.courses_backend.repository.CourseInstanceRepository;
import com.backend_courses.courses_backend.repository.CourseRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class CourseInstanceService implements ICourseInstanceServices {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseInstanceDTO> getAllCourseInstances() {
        return courseInstanceRepository.findAllWithCourses().stream()
                .map(this::convertToDTOWithCourse)
                .collect(Collectors.toList());
    }

    private CourseInstanceDTO convertToDTOWithCourse(CourseInstanceModel instance) {
        CourseInstanceDTO dto = new CourseInstanceDTO();
        dto.setId(instance.getId());
        dto.setYear(instance.getYear());
        dto.setSemester(instance.getSemester());
        dto.setTitle(instance.getCourse().getTitle());
        dto.setDescription(instance.getCourse().getDescription());
        dto.setCourseCode(instance.getCourse().getCourseCode());
        dto.setCourseid(instance.getCourse().getId());
        return dto;
    }

    @Override
    public String saveCourseInstance(CourseInstance courseInstance) {
        CourseInstanceModel imodel = new CourseInstanceModel();
        BeanUtils.copyProperties(courseInstance, imodel);

        CourseModel course = courseRepository.findById(courseInstance.getCourse())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseInstance.getId()));

        imodel.setCourse(course);

        courseInstanceRepository.save(imodel);
        return "Instance Saved Successfully.";
    }

    public String deleteCourseInstanceByCourseId(int year, int semester, Long courseId) {
        courseInstanceRepository.deleteByYearAndSemesterAndCourseId(year, semester, courseId);
        return "Deleted Successfully.";
    }

    // second
    public CourseInstanceDTO getCourseInstanceByYearSemId(int year, int semester, Long courseId) {
        CourseInstanceModel instance = courseInstanceRepository.findByYearAndSemesterAndCourseId(year, semester,
                courseId);
        return convertToDTO(instance);
    }

    private CourseInstanceDTO convertToDTO(CourseInstanceModel instance) {
        CourseInstanceDTO dto = new CourseInstanceDTO();
        BeanUtils.copyProperties(instance, dto);
        dto.setCourseid(instance.getCourse().getId());
        return dto;
    }

    // third
    public List<CourseInstanceDTO> getCourseInstancesByYearSem(int year, int semester) {
        List<CourseInstanceModel> instances = courseInstanceRepository.findByYearAndSemester(year, semester);
        return instances.stream()
                .map(this::convertyrsemToDTO)
                .collect(Collectors.toList());
    }

    private CourseInstanceDTO convertyrsemToDTO(CourseInstanceModel instance) {
        CourseInstanceDTO dto = new CourseInstanceDTO();
        BeanUtils.copyProperties(instance, dto);
        dto.setCourseid(instance.getCourse().getId());
        return dto;
    }




    
}
