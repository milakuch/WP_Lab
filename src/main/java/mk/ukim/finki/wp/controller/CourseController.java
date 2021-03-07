package mk.ukim.finki.wp.controller;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.model.Teacher;
import mk.ukim.finki.wp.service.CourseService;
import mk.ukim.finki.wp.service.StudentService;
import mk.ukim.finki.wp.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/","/coursesList"})
public class CourseController{
    private final CourseService cou;
    private final TeacherService tr;
    private final StudentService st;

    public CourseController(CourseService cou, TeacherService tr, StudentService st) {
        this.cou = cou;
        this.tr = tr;
        this.st = st;
    }



    @GetMapping("/courses")
    public String getCoursesPage(@RequestParam(required = false) String error, Model model){
        List<Course> courses=this.cou.listCourses();
        model.addAttribute("courses",courses);
        return "lab2/listCourses2";
    }


    @GetMapping
    public String getCoursesPageAnonymous(@RequestParam(required = false) String error, Model model){
        List<Course> courses=this.cou.listCourses();
        model.addAttribute("courses",courses);
        return "lab2/listCoursesAnonymous";
    }


    // Edit
    @GetMapping("/courses/add")
    public String saveCourse(@RequestParam(required = false) String error, Model model){
        List<Teacher> teachers=tr.findAll();
        model.addAttribute("teachers",teachers);
        return "lab2/createCourse";
    }

    @PostMapping("/courses/add/course")
    public String saveCourse(@RequestParam String name, @RequestParam String description, Long teacherID,@RequestParam(required = false) String tip) throws Exception {
        List<Student> students = new ArrayList<>();
        Teacher teacher = tr.findById(teacherID);

        Course c = new Course(name,description,students,teacher,Integer.parseInt(tip));
        c.setTeacher(teacher);
        cou.addCourse(c);

        return "redirect:/courses";
    }


//    @GetMapping("/courses/add/course")
//    public String saveCourse(@PathVariable Long id, Model model) throws Exception {
//        Course c = cou.findById(id);
//        List<Teacher> teachers=tr.findAll();
//        model.addAttribute("course",c);
//        model.addAttribute("teachers",teachers);
//        return "lab2/editCourse";
//    }

    // Delete
    // https://stackoverflow.com/questions/13106232/how-to-delete-a-record-using-spring-mvc-and-annotations
    @GetMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        cou.removeCourse(id);
        return "lab2/success2";
    }

    // Edit
    @GetMapping("/courses/edit-form/{id}")
    public String editCourse(@PathVariable Long id,Model model) throws Exception {
        Course c = cou.findById(id);
        List<Teacher> teachers=tr.findAll();
        model.addAttribute("course",c);
        model.addAttribute("teachers",teachers);
        return "lab2/editCourse";
    }

    @PostMapping("/courses/edit-form/{id}")
    public String editCourse(@RequestParam Long courseID,@RequestParam String name, @RequestParam String description, @RequestParam(required = false) Long teacherID,@RequestParam(required = false) String tip) throws Exception {
        List<Student> students = new ArrayList<>();
        Teacher teacher = tr.findById(teacherID);

        Course c = new Course(name,description,students,teacher,Integer.parseInt(tip));
        c.setTeacher(teacher);

        cou.removeCourse(courseID);
        cou.addCourse(c);
        return "redirect:/courses";
    }

//    @GetMapping("/login")
//    public String login(@RequestParam(required = false) String error, Model model){
//        return "lab2/login";
//    }

    @GetMapping("/student")
    public String getStudentPage(@RequestParam(required = false)  String error, Model model){
        List<Student> students =st.listAll();
        model.addAttribute("students",students);
        return "lab2/students";
    }

    @GetMapping("/AddStudent")
    public String addStudent(@RequestParam(name="courseID") Long courseID,Model model) throws Exception {
        Course c = cou.findById(courseID);
        List<Student> students = c.getStudents();
        model.addAttribute("courseName",c.getName());
        model.addAttribute("students",students);
        return "lab2/studentsInCourse";
    }

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/courses";
        }
        else return "redirect:/coursesList";
    }



}
