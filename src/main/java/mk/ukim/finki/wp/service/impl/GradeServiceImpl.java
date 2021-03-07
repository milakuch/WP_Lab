package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Grade;
import mk.ukim.finki.wp.repository.jpa.GradeRepository1;
import mk.ukim.finki.wp.service.CourseService;
import mk.ukim.finki.wp.service.GradeService;
import mk.ukim.finki.wp.service.StudentService;

import java.util.List;

public class GradeServiceImpl implements GradeService {


    private final GradeRepository1 gradeRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public GradeServiceImpl(GradeRepository1 gradeRepository, StudentService studentService, CourseService courseService) {
        this.gradeRepository = gradeRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    public List<Grade> getGradesForCourse(Long courseId) throws Exception {
        Course course = this.courseService.findById(courseId);
        return this.gradeRepository.findAllByCourse(course);
    }

}
