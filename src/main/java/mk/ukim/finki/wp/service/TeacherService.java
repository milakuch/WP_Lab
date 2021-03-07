package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherService {

    public List<Teacher> findAll();
    public Teacher findById(Long id) throws Exception;

}
