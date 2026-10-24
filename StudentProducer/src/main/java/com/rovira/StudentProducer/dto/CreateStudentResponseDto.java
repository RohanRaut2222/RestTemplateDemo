package com.rovira.StudentProducer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class CreateStudentResponseDto {
    private Long studentId;
    private String firstName;
}
