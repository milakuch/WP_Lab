package mk.ukim.finki.wp.controller;

import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.repository.impl.StudentRepository;
import mk.ukim.finki.wp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService st;

    public StudentController(StudentService st) {
        this.st = st;
    }

    @GetMapping("/student")
    public String getStudentPage(@RequestParam(required = false)  String error, Model model){
        List<Student> students =st.listAll();
        model.addAttribute("students",students);
        return "lab2/students";
    }

}
