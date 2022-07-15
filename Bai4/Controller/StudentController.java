package com.example.stringboot.Bai4.Controller;

import com.example.stringboot.Bai4.Model.Student;
import com.example.stringboot.Bai4.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping(value = "/Student", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> listAllStudent(){
        List<Student> listStudent = studentService.getAllStudent();
        if (listStudent.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listStudent,HttpStatus.OK);
    }
    @RequestMapping(value = "/Student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable("id")Long id){
        Student student = studentService.getOne(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
    @GetMapping(value = "/Student/code")
    public ResponseEntity<List<Student>> getAllStudentByCode(@RequestParam String code){
        return new ResponseEntity<>(studentService.getCode(code), HttpStatus.OK);
    }
    @GetMapping(value = "/Student/email")
    public ResponseEntity<List<Student>> getAllStudentByEmail(@RequestParam String email){
        return new ResponseEntity<>(studentService.getEmail(email), HttpStatus.OK);
    }
    @GetMapping(value = "/Student/phone")
    public ResponseEntity<List<Student>> getAllStudentByPhone(@RequestParam String phone){
        return new ResponseEntity<>(studentService.getPhone(phone), HttpStatus.OK);
    }
    @RequestMapping(value = "/Student", method = RequestMethod.POST)
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return ResponseEntity.ok(student);
    }
    @RequestMapping(value = "/Student/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@PathVariable("id")Long id,@RequestBody Student student){
        Student oldStudent = studentService.getOne(id);
        if (oldStudent == null){
            return ResponseEntity.notFound().build();
        } else {
            oldStudent.setCode(student.getCode());
            oldStudent.setName(student.getName());
            oldStudent.setEmail(student.getEmail());
            oldStudent.setPhone(student.getPhone());
            oldStudent.setAddress(student.getAddress());
            studentService.saveStudent(oldStudent);
            return ResponseEntity.ok(oldStudent);

        }
    }
    @RequestMapping(value = "/Student/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id){
        Optional<Student> _olderStudent = studentService.findStudentById(id);
        if (_olderStudent == null){
            return ResponseEntity.notFound().build();
        } else {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().build();
        }
    }
}
