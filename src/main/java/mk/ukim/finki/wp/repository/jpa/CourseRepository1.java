package mk.ukim.finki.wp.repository.jpa;

import mk.ukim.finki.wp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository1 extends JpaRepository<Course, Long> {
    List<Course> findAll();

}
