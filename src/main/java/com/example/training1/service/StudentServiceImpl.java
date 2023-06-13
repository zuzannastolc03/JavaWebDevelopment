package com.example.training1.service;

import com.example.training1.dao.StudentDAO;
import com.example.training1.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    StudentDAO studentDAO;
    StudentServiceImpl(StudentDAO theStudentDAO){
        studentDAO = theStudentDAO;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        studentDAO.save(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return studentDAO.findByLastName(lastName);
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
        studentDAO.updateStudent(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        studentDAO.deleteStudent(id);
    }
}
