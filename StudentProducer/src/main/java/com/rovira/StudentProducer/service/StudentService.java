package com.rovira.StudentProducer.service;

import org.springframework.stereotype.Service;

import com.rovira.StudentProducer.dto.CreateStudentRequestDto;
import com.rovira.StudentProducer.dto.CreateStudentResponseDto;
import com.rovira.StudentProducer.dto.GetStudentDto;
import com.rovira.StudentProducer.dto.UpdateStudentRequestDto;
import com.rovira.StudentProducer.dto.UpdateStudentResponseDto;

@Service 
public interface StudentService {

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto createStudentRequestDto);

    public GetStudentDto getStudentById(Long studentId);

    public UpdateStudentResponseDto updateStudent(UpdateStudentRequestDto updateStudentRequestDto, Long studentId);

    public void deleteStudent(Long studentId);

}
