package com.example.training1.dao;

import com.example.training1.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void updateStudent(Student theStudent);
}
