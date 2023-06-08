package com.example.training1.dao;

import com.example.training1.entity.Subject;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface SubjectDAO {
    void save(Subject theSubject);
    Subject findById(Integer id);
    List<Subject> findAll();
    List<Subject> findByName(String name);
}
