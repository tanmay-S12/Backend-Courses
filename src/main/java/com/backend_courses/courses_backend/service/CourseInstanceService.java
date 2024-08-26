package com.backend_courses.courses_backend.service;

import com.backend_courses.courses_backend.CourseInstance;
import com.backend_courses.courses_backend.model.CourseInstanceModel;
import com.backend_courses.courses_backend.repository.CourseInstanceRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CourseInstanceService implements ICourseInstanceServices {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Override
    public String saveCourseInstance(CourseInstance courseInstance) {
        CourseInstanceModel imodel = new CourseInstanceModel();
        BeanUtils.copyProperties(courseInstance, imodel);
        courseInstanceRepository.save(imodel);
        return "Instance Saved Successfully.";
    }

    @Override
    public List<CourseInstance> getAllInstances() {
        List<CourseInstanceModel> allInstances = courseInstanceRepository.findAll();
        List<CourseInstance> courseInstances = new ArrayList<>();

        for (CourseInstanceModel cinst : allInstances) {
            CourseInstance courseInstance = new CourseInstance();

            courseInstance.setId(cinst.getId());
            courseInstance.setCourse_id(cinst.getCourseId());
            courseInstance.setSemester(cinst.getSemester());
            courseInstance.setYear(cinst.getYear());

            courseInstances.add(courseInstance);
        }

        return courseInstances;
    }

    @Override
    public List<CourseInstance> getCoursesByYearAndSemester(int year, int semester) {
        List<CourseInstanceModel> instancesByYearSem = courseInstanceRepository.findByYearAndSemester(year, semester);
        List<CourseInstance> cInstanceByYearSem = new ArrayList<>();

        for (CourseInstanceModel cinst : instancesByYearSem) {

            CourseInstance courseins = new CourseInstance();
            courseins.setId(cinst.getId());
            courseins.setCourse_id(cinst.getCourseId());
            courseins.setSemester(cinst.getSemester());
            courseins.setYear(cinst.getYear());
            cInstanceByYearSem.add(courseins);
        }
        return cInstanceByYearSem;
    }

    public CourseInstance InstanceByYearAndSemesterAndCourseId(int year, int semester, Long courseId) {

        Optional<CourseInstanceModel> CourseInstanceModel = courseInstanceRepository
                .findByYearAndSemesterAndCourseId(year, semester, courseId);

        if (CourseInstanceModel.isPresent()) {
            CourseInstanceModel courseInstanceModel = CourseInstanceModel.get();
            CourseInstance courseInstance = new CourseInstance();
            courseInstance.setId(courseInstanceModel.getId());
            courseInstance.setCourse_id(courseInstanceModel.getCourseId());
            courseInstance.setSemester(courseInstanceModel.getSemester());
            courseInstance.setYear(courseInstanceModel.getYear());
            return courseInstance;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteCourseInstanceByCourseId(int year, int semester, Long courseId) {

        Optional<CourseInstanceModel> optionalCourseInstanceModel = courseInstanceRepository
                .findByYearAndSemesterAndCourseId(year, semester, courseId);

        if (optionalCourseInstanceModel.isPresent()) {

            courseInstanceRepository.delete(optionalCourseInstanceModel.get());
            return true;
        } else {
            return false;
        }
    }
}
