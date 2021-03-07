package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
//
//@Service
public interface StudentService {
    List<Student> listAll();
    List<Student> searchByNameOrSurname(String text);
    Student searchByUsername(String text);
    Student save(String username, String password, String name, String surname);
}