package com.springboot.demo.repository;

import com.springboot.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByMentorName(String mentorName);

    @Query("select s from Student s where s.email_address = ?1")
    public Student getStudentByEmail(String email);

    @Query("select s from Student s where s.address = ?1")
    public List<Student> getStudentsByAddress(String address);

    @Query(value = "SELECT * FROM student s WHERE s.first_name = ?1 AND s.second_name = ?2",
    nativeQuery = true)
    public List<Student> getStudentsByFirstNameAndSecondName(String firstName, String secondName);


    @Modifying
    @Transactional
    @Query(value = "UPDATE student s SET s.first_name = ?1 WHERE s.id = ?2",
           nativeQuery = true)
    public int updateStudentFirstNameById(String name, Long id);
}
