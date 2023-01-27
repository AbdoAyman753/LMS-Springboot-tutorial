package com.springboot.demo.repository;

import com.springboot.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Teacher teacher = Teacher.builder().
                firstName("Mohamed")
                .lastName("Mostafa")
                .build();
        teacherRepository.save(teacher);
    }

}