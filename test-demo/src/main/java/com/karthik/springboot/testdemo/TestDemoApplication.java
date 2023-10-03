package com.karthik.springboot.testdemo;

import com.karthik.springboot.testdemo.dao.StudentDAO;
import com.karthik.springboot.testdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO theStudent) {
        return runner -> {
            createStudent(theStudent);
            System.out.println("From command line runner!!");
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Abraham", "Lincoln", "ab.gmail.com");
        studentDAO.save(tempStudent);
        System.out.println("Student ID" + tempStudent.getId());
    }
}
