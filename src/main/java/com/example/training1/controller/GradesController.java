package com.example.training1.controller;

import com.example.training1.entity.Grade;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradesController {
    private List<Grade> listOfGrades;
    @PostConstruct
    public void loadGrades(){
        listOfGrades = new ArrayList<>();
        listOfGrades.add(new Grade(1, 1, 1, 1));
        listOfGrades.add(new Grade(2, 2, 2, 2));
        listOfGrades.add(new Grade(4, 2, 2, 1));
    }
    @GetMapping(value = {"", "/"})
    public String grades() {
        return "Welcome to grades section!";
    }

    @GetMapping("/list")
    public List<Grade> listGrades() {
        return listOfGrades;
    }
    @GetMapping("/{gradeId}")
    public Grade getGrade(@PathVariable("gradeId") int gradeId){
        if((gradeId >= listGrades().size()) || (gradeId < 0)){
            throw new NotFoundException("Grade ID not found: " + gradeId);
        }
        return listOfGrades.get(gradeId);
    }
}
