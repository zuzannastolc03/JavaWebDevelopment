package com.example.training1.controller;

import com.example.training1.teacher.Teacher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeachersController {
    private final Teacher englishTeacher, mathsTeacher, physicalEducationTeacher;

    @Value("${subject.name}")
    private String subject;

    TeachersController(@Qualifier("english") Teacher theEnglishTeacher, @Qualifier("maths") Teacher theMathsTeacher,
                       @Qualifier("physicalEducation") Teacher thePhysicalEducationTeacher) {
        englishTeacher = theEnglishTeacher;
        mathsTeacher = theMathsTeacher;
        physicalEducationTeacher = thePhysicalEducationTeacher;
    }

    @GetMapping(value = {"", "/"})
    public String teachers() {
        return "Welcome to teachers section!";
    }

    @GetMapping("/maths")
    public String mathsTeacher() {
        return mathsTeacher.pleaseLearn();
    }

    @GetMapping("/english")
    public String englishTeacher() {
        return englishTeacher.pleaseLearn();
    }

    @GetMapping("/physicalEducation")
    public String physicalEducationTeacher() {
        return physicalEducationTeacher.pleaseLearn();
    }

    @GetMapping("/subject")
    public String theTeacher() {
        return "There is no homework to do in " + subject;
    }
}
