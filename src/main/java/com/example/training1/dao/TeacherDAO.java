package com.example.training1.dao;

import com.example.training1.entity.Teacher;

import java.util.List;

public interface TeacherDAO {
    void save(Teacher theTeacher);
    Teacher findById(Integer id);
    List<Teacher> findAll();
    List<Teacher> findByLastName(String lastName);
    void updateTeacher(Teacher theTeacher);
}
