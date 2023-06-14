package com.example.training1.service;

import com.example.training1.dao.StudentRepository;
import com.example.training1.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    StudentRepository studentRepository;
    StudentServiceImpl(StudentRepository theStudentRepository){
        studentRepository = theStudentRepository;
    }

    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        Optional<Student> result = studentRepository.findById(id);
        Student theStudent = null;
        if(result.isPresent()){
            theStudent =  result.get();
        }
        return theStudent;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

//    @Override
//    public void updateStudent(Student theStudent) {
//        studentRepository.updateStudent(theStudent);
//    }

//    @Override
//    public void deleteStudent(Integer id) {
//        studentRepository.deleteStudent(id);
//    }
}
