package com.example.training1.dao;

import com.example.training1.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student Where lastName=:theData", Student.class);
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
        entityManager.merge(theStudent);
    }
}
