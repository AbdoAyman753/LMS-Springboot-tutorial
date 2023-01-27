package com.springboot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Student" , uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email"))
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    @Column(name = "email", nullable = false)
    private String email_address;

    @Embedded
    private Mentor mentor;
}


