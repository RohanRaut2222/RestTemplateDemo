package com.rovira.StudentConsumer.dto;

import java.time.LocalDate;

import com.rovira.StudentConsumer.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class UpdateStudentRequestDto {

    private String course;
    private String email;
    private Gender gender;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Double percentage;
    private LocalDate dateOfBirth;

}
