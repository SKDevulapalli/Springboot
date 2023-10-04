package com.karthik.springboot.cruddemo.service;

import com.karthik.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //same methods as in DAO Interface
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
