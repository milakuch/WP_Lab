package mk.ukim.finki.wp.model;
import lombok.Data;
//import mk.ukim.finki.wp.service.CourseService;


import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Course {
//    enum Tip { MANDATORY, OPTIONAL}

    public enum Tip {
        MANDATORY(0), OPTIONAL(1);
        private final int id;
        Tip(int id) { this.id = id; }
        public int getValue() { return id; }
    }

    @Id
    Long courseId;
    String name, description;

    @ManyToMany
    List<Student> students;

    @ManyToOne
    Teacher teacher;
    Tip tip;

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course() {
    }

    public Course(String name) {
        this.courseId= (long) (Math.random() * 1000);
        this.name = name;
    }

    public Course(String name, String description, List<Student> students) {
        this.courseId = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.students = students;
    }

    public Course(String name, String description, List<Student> students, Teacher teacher) {
        this.courseId = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.students = students;
        this.teacher = teacher;
    }

    public Course(String name, String description, List<Student> students, Teacher teacher, int tip) {
        this.courseId = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.students = students;
        this.teacher = teacher;
        if(tip==0)
            this.tip = Tip.MANDATORY;
        else
            this.tip = Tip.OPTIONAL;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getDescription() {
        return description;
    }

    public List<Student> getStudents() {
        return students;
    }
}
