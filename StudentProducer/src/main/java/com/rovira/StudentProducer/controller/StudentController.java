package com.rovira.StudentProducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rovira.StudentProducer.dto.CreateStudentRequestDto;
import com.rovira.StudentProducer.dto.CreateStudentResponseDto;
import com.rovira.StudentProducer.dto.GetStudentDto;
import com.rovira.StudentProducer.dto.UpdateStudentRequestDto;
import com.rovira.StudentProducer.dto.UpdateStudentResponseDto;
import com.rovira.StudentProducer.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/student")
@RequiredArgsConstructor 
public class StudentController {

    @Autowired 
    private final StudentService studentService;

    @PostMapping ("/create")
    public ResponseEntity<CreateStudentResponseDto> createStudent(@RequestBody CreateStudentRequestDto createStudentRequestDto){
        CreateStudentResponseDto createStudentResponseDto = studentService.createStudent(createStudentRequestDto);
        return ResponseEntity.ok(createStudentResponseDto);
    }

    @GetMapping ("/get/{studentId}")
    public ResponseEntity<GetStudentDto> getStudentById(@PathVariable Long studentId){
        GetStudentDto getStudentDto = studentService.getStudentById(studentId);
        return ResponseEntity.ok(getStudentDto);
    }

    @PutMapping ("/update/{studentId}")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestBody UpdateStudentRequestDto updateStudentRequestDto, @PathVariable Long studentId)
    {
        return new ResponseEntity<>(studentService.updateStudent(updateStudentRequestDto,studentId),
                                   HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId)
    {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
