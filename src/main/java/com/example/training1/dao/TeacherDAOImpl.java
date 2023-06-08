package com.example.training1.dao;

import com.example.training1.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO{
    private EntityManager entityManager;

    public TeacherDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Teacher theTeacher) {
        entityManager.persist(theTeacher);
    }

    @Override
    public Teacher findById(Integer id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    public List<Teacher> findAll() {
        TypedQuery<Teacher> theQuery = entityManager.createQuery("From Teacher order by lastName", Teacher.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Teacher> findByLastName(String lastName) {
        TypedQuery<Teacher> theQuery = entityManager.createQuery("From Teacher where lastName=:theData", Teacher.class);
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateTeacher(Teacher theTeacher) {
        entityManager.merge(theTeacher);
    }
}
