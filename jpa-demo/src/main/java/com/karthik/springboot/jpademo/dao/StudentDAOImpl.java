package com.karthik.springboot.jpademo.dao;

import com.karthik.springboot.jpademo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {


    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    //No need to add transactional because this is read-only operation
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //Note that this is not the database table name, but the Entity name
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        Student tempStudent = entityManager.find(Student.class, id);
        //delete the student
        entityManager.remove(tempStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numOfRowsDeleted = entityManager.createQuery("DELETE FROM Student", Student.class).executeUpdate();
        return numOfRowsDeleted;
    }
}
