package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Grade;

import java.util.List;

public interface GradeService {

    public List<Grade> getGradesForCourse(Long courseId) throws Exception;
}
