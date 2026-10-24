package com.rovira.StudentConsumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class UpdateStudentResponseDto {
    private Long studentId;
    private String firstName;

}
