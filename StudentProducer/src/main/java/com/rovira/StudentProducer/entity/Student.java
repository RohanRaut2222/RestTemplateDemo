package com.rovira.StudentProducer.entity;

import java.time.LocalDate;

import com.rovira.StudentProducer.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Student {

    @Id
    @SequenceGenerator (name = "student_seq", sequenceName = "student_seq", allocationSize = 1, initialValue = 1000)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "student_seq")
    private Long studentId;
    @Column (nullable = false)
    private String course;
    @Column (nullable = false)
    private String email;
    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private Gender gender;

    @Column (nullable = false)
    private String firstName;
    @Column (nullable = false)
    private String lastName;
    @Column (nullable = false)
    private String phoneNumber;

    @Column (nullable = false)
    private Double percentage;
    private LocalDate dateOfBirth;

}
