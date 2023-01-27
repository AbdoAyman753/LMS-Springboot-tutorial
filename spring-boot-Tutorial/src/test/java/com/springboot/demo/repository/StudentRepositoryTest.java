package com.springboot.demo.repository;

import com.springboot.demo.entity.Mentor;
import com.springboot.demo.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
*/
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Mentor mentor = Mentor.builder()
                .name("Watheq")
                .email("watheq.999@gmail.com")
                .mobileNumber("0109999999")
                .build();

        Student student = Student.builder()
                .firstName("Abdelsalam")
                .lastName("adel")
                .address("10th of Ramadan")
                .email_address("salam_2000@gmail.com")
                .mentor(mentor)
                .build();
        studentRepository.save(student);

        /*student = Student.builder()
                .firstName("Abdelrahman")
                .secondName("Ayman")
                .address("Cairo")
                .email_address("abdobebo1998@gmail.com")
                .build();*/
        studentRepository.save(student);

    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }
    @Test()
    @DisplayName("Test findByName")
    public void findByName() {
        List<Student> studentList = studentRepository.findByFirstName("Abdallah");
        System.out.println("studentList = " + studentList);
    }

    @Test
    @DisplayName("Test findByNameContaining")
    public void findByNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("Abd");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void findByMentorName(){
        List<Student> studentList = studentRepository.findByMentorName("Watheq");
        System.out.println("studentList = " + studentList);
    }
    @Test
     public void getByEmail(){
        Student student = studentRepository.getStudentByEmail("abdobebo1998@gmail.com");
         System.out.println("studentList = " + student);
     }
    @Test
    public void getByAddress(){
        List<Student> studentList = studentRepository.getStudentsByAddress("10th of Ramadan");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void getByFirstName(){
        List<Student> studentList = studentRepository.getStudentsByFirstNameAndSecondName("Abdelrahman", "Ayman");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void updateStudentFirstNameById(){
        int bool = studentRepository.updateStudentFirstNameById("Abdelhady", 5L);
        System.out.println("bool = " + bool);
    }
}