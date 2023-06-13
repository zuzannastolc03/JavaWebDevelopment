package com.example.training1.controller;

import com.example.training1.entity.Student;
import com.example.training1.entity.Subject;
import com.example.training1.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectsController {
    SubjectService subjectService;
    SubjectsController(SubjectService theSubjectService){
        subjectService = theSubjectService;
    }
    @GetMapping(value = {"", "/"})
    public String subjects(){
        return "Welcome to subjects section!";
    }

    @GetMapping("/list")
    public List<Subject> listSubjects(){
        return subjectService.findAll();
    }

    @GetMapping("/{subjectId}")
    public Subject getSubject(@PathVariable("subjectId") int subjectId){
        Subject theSubject = subjectService.findById(subjectId);
        if(theSubject == null){
            throw new NotFoundException("Subject ID not found: " + subjectId);
        }
        return theSubject;
    }

    @PostMapping(value = {"", "/"})
    public Subject addSubject(@RequestBody Subject theSubject){
        theSubject.setId(0);
        subjectService.save(theSubject);
        return theSubject;
    }
}
