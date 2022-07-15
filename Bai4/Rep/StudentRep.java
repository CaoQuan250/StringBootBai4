package com.example.stringboot.Bai4.Rep;

import com.example.stringboot.Bai4.Model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRep extends JpaRepository<Student, Long> {

    List<Student> findAllByOrderByIdAsc();

    List<Student> findCode(String code);

    List<Student> findEmail(String email);

    List<Student> findPhone(String phone);

}
