package com.example.stringboot.Bai4.Service;

import com.example.stringboot.Bai4.Model.Student;


import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudent();
    void saveStudent(Student student);
    void deleteStudent(Long id);
    Optional<Student> findStudentById(Long Id);
     Student getOne(Long id);
     List<Student> getCode(String code);
     List<Student> getEmail(String email);
     List<Student> getPhone(String phone);

}
