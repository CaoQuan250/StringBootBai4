package com.example.stringboot.Bai4.Service;

import com.example.stringboot.Bai4.Model.Student;
import com.example.stringboot.Bai4.Rep.StudentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRep studentRep;
    @Override
    public List<Student> getAllStudent() {
        return studentRep.findAllByOrderByIdAsc();
    }
    @Override
    public void saveStudent(Student student) {
        studentRep.save(student);
    }
    @Override
    public void deleteStudent(Long id) {
        studentRep.deleteById(id);
    }
    @Override
    public Optional<Student> findStudentById(Long Id) {
        return studentRep.findById(Id);
    }
    @Override
    public Student getOne(Long id) {
        return studentRep.findById(id).get();
    }
    @Override
    public List<Student> getCode(String code) {
        return studentRep.findCode(code);
    }
    @Override
    public List<Student> getEmail(String email) {
        return studentRep.findEmail(email) ;
    }
    @Override
    public List<Student> getPhone(String phone) {
        return studentRep.findPhone(phone);
    }
}
