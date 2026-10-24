package com.rovira.StudentProducer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class ApiResponseDto {

    private String errorDesc;
    private String errorMsg;
    private Integer errorCode;
    
}
