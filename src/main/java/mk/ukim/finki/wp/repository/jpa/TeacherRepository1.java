package mk.ukim.finki.wp.repository.jpa;

import mk.ukim.finki.wp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository1 extends JpaRepository<Teacher, Long> {

}
