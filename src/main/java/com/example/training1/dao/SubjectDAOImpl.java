package com.example.training1.dao;

import com.example.training1.entity.Subject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SubjectDAOImpl implements SubjectDAO{
    private EntityManager entityManager;

    public SubjectDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Subject theSubject) {
        entityManager.persist(theSubject);
    }

    @Override
    public Subject findById(Integer id) {
        return entityManager.find(Subject.class, id);
    }

    @Override
    public List<Subject> findAll() {
        TypedQuery<Subject> theQuery = entityManager.createQuery("From Subject order by name", Subject.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Subject> findByName(String name) {
        TypedQuery<Subject> theQuery = entityManager.createQuery("From Subject where name=:theData", Subject.class);
        theQuery.setParameter("theData", name);
        return theQuery.getResultList();
    }
}
