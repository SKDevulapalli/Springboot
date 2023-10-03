package com.karthik.springboot.jpademo.rest;

import com.karthik.springboot.jpademo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    private List<Student> theStudents;

    //defined here to load data only once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Ram", "VP", "ram.vp@gmail.com"));
        theStudents.add(new Student("Bheem", "KP", "bheem.kp@gmail.com"));
        theStudents.add(new Student("Som", "LP", "som.lp@gmail.com"));

    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }


    @GetMapping("/students")
    public List<Student> printAll() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student printAll(@PathVariable int studentId) {
        if (studentId > theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Could not find a given Student Id");
        }
        return theStudents.get(studentId);
    }

}
