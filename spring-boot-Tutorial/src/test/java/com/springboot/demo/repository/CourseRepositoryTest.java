package com.springboot.demo.repository;

import com.springboot.demo.entity.Course;
import com.springboot.demo.entity.CourseMaterial;
import com.springboot.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void saveCourse(){
        Teacher teacher = Teacher.builder()
                .firstName("Ahmed")
                .lastName("Alaa")
                .build();

        Course course = Course.builder()
                .courseTitle("CSE101")
                .creditHours(20)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

}