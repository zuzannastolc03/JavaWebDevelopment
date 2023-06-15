//package com.example.training1.dao;
//
//import com.example.training1.entity.Grade;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Repository
//public class GradeDAOImpl implements GradeDAO {
//    private EntityManager entityManager;
//
//    public GradeDAOImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    @Transactional
//    public void save(Grade theGrade) {
//        entityManager.persist(theGrade);
//    }
//
//    @Override
//    public Grade findById(Integer id) {
//        return entityManager.find(Grade.class, id);
//    }
//
//    @Override
//    public List<Grade> findAll() {
//        TypedQuery<Grade> theQuery = entityManager.createQuery("From Grade", Grade.class);
//        return theQuery.getResultList();
//    }
//
//    @Override
//    @Transactional
//    public void updateGrade(Grade theGrade) {
//        entityManager.merge(theGrade);
//    }
//
//    @Override
//    @Transactional
//    public void deleteGrade(Integer id) {
//        Grade tempGrade = findById(id);
//        entityManager.remove(tempGrade);
//    }
//
//    @Override
//    @Transactional
//    public int deleteAllGrades() {
//        return entityManager.createQuery("Delete from Grade").executeUpdate();
//    }
//}
