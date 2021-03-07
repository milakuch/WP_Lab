package mk.ukim.finki.wp.repository.jpa;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Grade;

import java.util.List;

public interface GradeRepository1 {
    List<Grade> findAllByCourse(Course course);
}
