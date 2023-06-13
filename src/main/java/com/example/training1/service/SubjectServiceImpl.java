package com.example.training1.service;

import com.example.training1.dao.SubjectDAO;
import com.example.training1.entity.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{
    SubjectDAO subjectDAO;
    SubjectServiceImpl(SubjectDAO theSubjectDAO){
        subjectDAO = theSubjectDAO;
    }

    @Override
    @Transactional
    public void save(Subject theSubject) {
        subjectDAO.save(theSubject);
    }

    @Override
    public Subject findById(Integer id) {
        return subjectDAO.findById(id);
    }

    @Override
    public List<Subject> findAll() {
        return subjectDAO.findAll();
    }

    @Override
    public List<Subject> findByName(String name) {
        return subjectDAO.findByName(name);
    }
}
