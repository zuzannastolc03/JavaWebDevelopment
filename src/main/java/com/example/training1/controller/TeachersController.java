package com.example.training1.controller;

import com.example.training1.teacher.Teacher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class TeachersController {
    private final Teacher englishTeacher, mathsTeacher;
    TeachersController(@Qualifier("english") Teacher theEnglishTeacher, @Qualifier("maths") Teacher theMathsTeacher){
        englishTeacher = theEnglishTeacher;
        mathsTeacher = theMathsTeacher;
    }
    @GetMapping(value = {"", "/"})
    public String teachers(){
        return "Welcome to teachers section!";
    }
    @GetMapping("/maths")
    public String mathsTeacher(){
        return mathsTeacher.pleaseLearn();
    }
    @GetMapping("/english")
    public String englishTeacher(){
        return englishTeacher.pleaseLearn();
    }
}
