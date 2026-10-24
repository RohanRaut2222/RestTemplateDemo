package com.rovira.StudentProducer.dto;

import java.time.LocalDate;
import com.rovira.StudentProducer.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class CreateStudentRequestDto {
    private String course;
    private String email;
    private Gender gender;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Double percentage;
    private LocalDate dateOfBirth;
}
