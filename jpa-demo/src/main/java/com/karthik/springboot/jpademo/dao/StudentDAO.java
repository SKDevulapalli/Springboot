package com.karthik.springboot.jpademo.dao;

import com.karthik.springboot.jpademo.entity.Student;
import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    void update (Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
