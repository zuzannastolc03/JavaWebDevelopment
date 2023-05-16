package com.example.training1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomePageController {
    @GetMapping("/")
    public String basic(){
        return "Hello!";
    }

    @GetMapping("/world")
    public String world(){
        return "Hello world!";
    }

    // do poniższego wchodzę na localhost:8080/pathvariable/Jakub
    @GetMapping("/pathvariable/{name}")
    public String pathVariable(@PathVariable("name") String name){
        return "Hello " + name + "!";
    }

    // do poniższego wchodzę na localhost:8080/requestparam?imie=Jakub
    @GetMapping ("/requestparam")
    public String requestParam(@RequestParam(name = "imie") String name){
        return "Hello " + name + "!";
    }

}
