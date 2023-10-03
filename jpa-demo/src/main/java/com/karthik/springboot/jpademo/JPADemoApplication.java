package com.karthik.springboot.jpademo;

import com.karthik.springboot.jpademo.dao.StudentDAO;
import com.karthik.springboot.jpademo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JPADemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JPADemoApplication.class, args);
    }

    //@Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            //readStudent(studentDAO);
            //queryForStudents(studentDAO);
            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudents(studentDAO);

            System.out.println("From command line runner!!");
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        int numOfRowsDeleted = studentDAO.deleteAll();
        System.out.println("numOfRows");
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId =202;
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        Student tempStudent = studentDAO.findById(studentId);
        tempStudent.setFirstName("Super Abraham");
        System.out.println(tempStudent.getFirstName());
        studentDAO.update(tempStudent);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findAll();
        for (Student tempStudent : theStudents) {
            System.out.println("Students  " + tempStudent);
        }
    }

    private void createStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Martin", "Luther King", "mlk.gmail.com");
        studentDAO.save(tempStudent);
        System.out.println("Student ID " + tempStudent.getId());
    }

    private void readStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Mahatma", "Gandhi", "mg.gmail.com");
        studentDAO.save(tempStudent);

        int newId = tempStudent.getId();
        System.out.println("Student ID " + newId);

        Student myStudent = studentDAO.findById(newId);
    }
}
