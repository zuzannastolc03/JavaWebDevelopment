package com.example.training1.service;

import com.example.training1.entity.Subject;

import java.util.List;

public interface SubjectService {
    void save(Subject theSubject);
    Subject findById(Integer id);
    List<Subject> findAll();
    List<Subject> findByName(String name);
}
