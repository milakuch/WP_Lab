package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService{
    List<Course> listCourses();
    List<Student> listStudentsByCourse(Long courseId) throws Exception;
    Course addStudentInCourse(String username, Long courseId) throws Exception;

    void removeCourse(Long id);
    void addCourse(Course c);
    Course findById(Long courseId) throws Exception;
//    List<Course> listMandatory();
//    List<Course> listOptional();
}