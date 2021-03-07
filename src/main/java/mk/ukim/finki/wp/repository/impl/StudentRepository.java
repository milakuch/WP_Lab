package mk.ukim.finki.wp.repository.impl;

import mk.ukim.finki.wp.model.Student;
import org.springframework.stereotype.Repository;
import mk.ukim.finki.wp.service.StudentService;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    List<Student> students;

    public StudentRepository() {

        students= new ArrayList<Student>(5);
        students.add(new Student("student6","123","Student","6"));
        students.add(new Student("student7","123","Student","7"));

    }

    public List<Student> findAllStudents(){
        return students;
    };

    public List<Student> findAllByNameOrSurname(String text){
        List<Student> result = new ArrayList<Student>();
        for (Student student : students){
            if(student.getName().equals(text) || student.getSurname().equals(text)){
                result.add(student);
            }
        }
        return result;
    };

    public List<Student> listAll() {
        return students;
    }

    public List<Student> searchByNameOrSurname(String text) {
        return null;
    }

    public Student searchByUsername(String text) {
        for (Student student : students){
            if(student.getUsername().equals(text)){
                return student;
            }
        }
        return null;
    }

    public Student save(String username, String password, String name, String surname) {
        Student s = new Student(username,password,name,surname);
        students.add(s);
        return s;
    }


}
