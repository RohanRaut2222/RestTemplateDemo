package com.rovira.StudentConsumer.studentController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rovira.StudentConsumer.dto.CreateStudentRequestDto;
import com.rovira.StudentConsumer.dto.UpdateStudentRequestDto;
import com.rovira.StudentConsumer.studentService.StudentService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/student")
@RequiredArgsConstructor 
public class StudentController {

    @Autowired 
    private final StudentService studentService;

    @GetMapping ("/get/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable Long studentId)
    {
        return studentService.getStudent(studentId);
    }

    @PostMapping ("/create")
    public ResponseEntity<?> createStudent(@RequestBody CreateStudentRequestDto createStudentRequestDto)
    {
        return studentService.createStudent(createStudentRequestDto);
    }

    @PutMapping ("/update/{studentId}")
    public ResponseEntity<?> updateStudent(@RequestBody UpdateStudentRequestDto updateStudentRequestDto, @PathVariable Long studentId)
    {
        return studentService.updateStudent(updateStudentRequestDto, studentId);
    }

    @DeleteMapping ("delete/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentId)
    {
        return studentService.deleteStudent(studentId);
    }

}
