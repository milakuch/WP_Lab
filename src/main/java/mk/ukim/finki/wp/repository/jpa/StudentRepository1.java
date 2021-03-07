package mk.ukim.finki.wp.repository.jpa;

import mk.ukim.finki.wp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository1 extends JpaRepository<Student, String> {
    List<Student> findAll();
    Student save(Student s);
    List<Student> findAllByNameOrSurnameLike(String text,String t);
    Student findByUsername(String text);

}
