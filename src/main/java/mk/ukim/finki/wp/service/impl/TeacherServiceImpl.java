package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Teacher;
import mk.ukim.finki.wp.repository.jpa.TeacherRepository1;
import mk.ukim.finki.wp.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {


    private final TeacherRepository1 teacherRepository;

    public TeacherServiceImpl(TeacherRepository1 teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return this.teacherRepository.findAll();
    }

    @Override
    public Teacher findById(Long id) throws Exception {
        return teacherRepository.findById(id).orElseThrow(() -> new Exception(String.valueOf(id)));
    }

//    @Override
//    public Teacher findById(Long id) {
//        return this.teacherRepository.findById(id).orElseThrow(() -> new Exception(String.valueOf(id)));
//    }
}
