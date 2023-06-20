package com.example.training1.controller;
import com.example.training1.entity.Student;
import com.example.training1.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// When I want to work with API
//@RestController
// When I want to use thymeleaf
@Controller
@RequestMapping("/students")
public class StudentsController {
    StudentService studentService;
    StudentsController(StudentService theStudentService){
        studentService = theStudentService;
    }

    @GetMapping(value = {"", "/"})
    public String students(Model theModel){
        theModel.addAttribute("theDate", new java.util.Date());
        // this will redirect to helloWorld.html, when working with thymeleaf
        return "helloWorld";
        // this works when working with API
//        return "Welcome to Students section!";
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

    @PutMapping(value = {"", "/"})
    public Student updateStudent(@RequestBody Student theStudent){
        studentService.save(theStudent);
        return theStudent;
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable("studentId") int studentId){
        Student theStudent = studentService.findById(studentId);
        if(theStudent == null){
            throw new NotFoundException("Student ID not found: " + studentId);
        }
        studentService.deleteStudent(studentId);
        return "Deleted record at id: " + studentId;
    }
}
