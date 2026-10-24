package com.rovira.StudentConsumer.studentService;

import org.springframework.http.ResponseEntity;

import com.rovira.StudentConsumer.dto.CreateStudentRequestDto;
import com.rovira.StudentConsumer.dto.UpdateStudentRequestDto;

public interface StudentService {

    public ResponseEntity<?> getStudent(Long studentId);

    public ResponseEntity<?> createStudent(CreateStudentRequestDto createStudentRequestDto);

    public ResponseEntity<?> updateStudent(UpdateStudentRequestDto updateStudentRequestDto, Long studentId);

    public ResponseEntity<?> deleteStudent(Long studentId);


}
