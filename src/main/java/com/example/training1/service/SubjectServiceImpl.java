package com.example.training1.service;

import com.example.training1.dao.SubjectRepository;
import com.example.training1.entity.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService{
    SubjectRepository subjectRepository;
    SubjectServiceImpl(SubjectRepository theSubjectRepository){
        subjectRepository = theSubjectRepository;
    }

    @Override
    public void save(Subject theSubject) {
        subjectRepository.save(theSubject);
    }

    @Override
    public Subject findById(Integer id) {
        Optional<Subject> result = subjectRepository.findById(id);
        Subject theSubject = null;
        if(result.isPresent()){
            theSubject=  result.get();
        }
        return theSubject;
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Subject> findByName(String name) {
        return subjectRepository.findByName(name);
    }
}
