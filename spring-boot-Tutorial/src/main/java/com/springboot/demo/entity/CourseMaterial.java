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
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "course_id",referencedColumnName = "courseCode")
    private Course course;
}
