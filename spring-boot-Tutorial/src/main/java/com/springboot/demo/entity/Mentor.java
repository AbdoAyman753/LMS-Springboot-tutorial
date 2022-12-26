package com.springboot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "Mentor_Name")),
        @AttributeOverride(name = "email", column = @Column(name = "Mentor_Email")),
        @AttributeOverride(name = "mobileNumber", column = @Column(name = "Mentor_Mobile_Number"))
})
@Builder
public class Mentor {
    private String name;
    private String email;
    private String mobileNumber;
}
