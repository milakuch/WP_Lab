package mk.ukim.finki.wp.service.impl;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.repository.jpa.StudentRepository1;
import mk.ukim.finki.wp.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository1 studentRepository1;

    public StudentServiceImpl(StudentRepository1 studentRepository1) {
        this.studentRepository1 = studentRepository1;
    }

    @Override
    public List<Student> listAll() {
        return this.studentRepository1.findAll();
    }


    @Override
    public List<Student> searchByNameOrSurname(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        String t=text;
        return this.studentRepository1.findAllByNameOrSurnameLike(text,t);
    }

    @Override
    public Student searchByUsername(String text) {
        return studentRepository1.findByUsername(text);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty() ||
                name == null || name.isEmpty() || surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return this.studentRepository1.save(new Student(username, password, name, surname));
    }
}
