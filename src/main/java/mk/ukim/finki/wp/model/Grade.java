package mk.ukim.finki.wp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Character grade;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;

    public Grade() { }

    public Grade(Character grade, Student student, Course course) {
        this.id = (long) (Math.random() * 1000);
        this.grade = grade;
        this.student = student;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getGrade() {
        return grade;
    }

    public void setGrade(Character grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
