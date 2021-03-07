package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.repository.jpa.CourseRepository1;
import mk.ukim.finki.wp.service.CourseService;
import mk.ukim.finki.wp.service.StudentService;
import mk.ukim.finki.wp.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository1 courseRepository;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public CourseServiceImpl(CourseRepository1 courseRepository, StudentService studentService, TeacherService teacherService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Override
    public List<Course> listCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) throws Exception {
        if (courseId == null) {
            throw new IllegalArgumentException();
        }
        return this.findById(courseId).getStudents();
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) throws Exception {
        if (username == null || username.isEmpty() || courseId == null) {
            throw new IllegalArgumentException();
        }

        Student student = studentService.searchByUsername(username);
        Course course = this.findById(courseId);
         course.getStudents().add(student);
        this.courseRepository.save(course);
        return course;
    }

    @Override
    public void removeCourse(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        this.courseRepository.deleteById(id);
    }

    @Override
    public void addCourse(Course c) {
        this.courseRepository.save(c);
    }

    @Override
    public Course findById(Long courseId) throws Exception {
        if (courseId == null) {
            throw new IllegalArgumentException();
        }
        return this.courseRepository.findById(courseId).orElse(null);

    }

//    @Override
//    public List<Course> listMandatory() {
//        return courseRepository.listMandatory();
//    }

//    @Override
//    public List<Course> listOptional() {
//        return courseRepository.listOptional();
//    }
}
