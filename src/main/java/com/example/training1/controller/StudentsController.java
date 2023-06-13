package com.example.training1.controller;
import com.example.training1.entity.Student;
import com.example.training1.entity.Subject;
import com.example.training1.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    StudentService studentService;
    StudentsController(StudentService theStudentService){
        studentService = theStudentService;
    }

    @GetMapping(value = {"", "/"})
    public String students(){
        return "Welcome to students section!";
    }

    @GetMapping("/list")
    public List<Student> listStudents(){
        return studentService.findAll();
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId){
        Student theStudent = studentService.findById(studentId);
        if(theStudent == null){
            throw new NotFoundException("Student ID not found: " + studentId);
        }
        return theStudent;
    }

    @PostMapping(value = {"", "/"})
    public Student addStudent(@RequestBody Student theStudent){
        theStudent.setId(0);
        studentService.save(theStudent);
        return theStudent;
    }
}
