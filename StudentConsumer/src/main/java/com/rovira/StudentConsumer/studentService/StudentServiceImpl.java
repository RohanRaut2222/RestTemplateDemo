package com.rovira.StudentConsumer.studentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.rovira.StudentConsumer.dto.ApiResponseDto;
import com.rovira.StudentConsumer.dto.CreateStudentRequestDto;
import com.rovira.StudentConsumer.dto.CreateStudentResDto;
import com.rovira.StudentConsumer.dto.GetStudentsDto;
import com.rovira.StudentConsumer.dto.UpdateStudentRequestDto;
import com.rovira.StudentConsumer.dto.UpdateStudentResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.val;
import tools.jackson.databind.ObjectMapper;

@Service (value = "studentService")
@RequiredArgsConstructor 
public class StudentServiceImpl implements StudentService{

    @Autowired 
    private final RestTemplate restTemplate;

    @Value ("${student.service.base-url}")
    private String studentBaseUrl;

     public ResponseEntity<?> getStudent(Long studentId)
     {
         String URL =studentBaseUrl+"/get/{studentId}";
         ResponseEntity<?>  student;
         try{
            HttpHeaders headers = new HttpHeaders();
            headers.add("Accept", "application/json");

            HttpEntity httpEntity = new HttpEntity<>(headers);
            student =
            restTemplate.exchange(URL,HttpMethod.GET,httpEntity,GetStudentsDto.class,studentId);


            return student;
            
         }
         catch(HttpClientErrorException ex)
         {
            ObjectMapper objectMapper = new ObjectMapper();

            ApiResponseDto apiResponseDto = objectMapper.readValue(ex.getResponseBodyAsString(), ApiResponseDto.class);
            
            return new ResponseEntity<ApiResponseDto>(apiResponseDto,ex.getStatusCode());
         }
     }

     public ResponseEntity<?> createStudent(CreateStudentRequestDto createStudentRequestDto)
     {
         ResponseEntity<?> response;
         String URL = studentBaseUrl+"/create";
         try
         {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");

            HttpEntity entity = new HttpEntity<CreateStudentRequestDto>(createStudentRequestDto, headers);

            response = 
            restTemplate.exchange(URL,HttpMethod.POST,entity,CreateStudentResDto.class);

            return response;
         }
         catch(HttpClientErrorException ex)
         {
            ObjectMapper objectMapper = new ObjectMapper();

            ApiResponseDto apiResponseDto = objectMapper.readValue(ex.getResponseBodyAsString(), ApiResponseDto.class);
            response = new ResponseEntity<>(apiResponseDto,ex.getStatusCode());
            return response;

         }
      }

      public ResponseEntity<?> updateStudent(UpdateStudentRequestDto updateStudentRequestDto, Long studentId)
      {
         ResponseEntity<?> response;
         String URL = studentBaseUrl+"/update/{studentId}";
         try{
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");

            HttpEntity entity = new HttpEntity<>(updateStudentRequestDto,headers);

            response = 
            restTemplate.exchange(URL,HttpMethod.PUT,entity,UpdateStudentResponseDto.class,studentId);
            return response;
         }
         catch(HttpClientErrorException ex)
         {
            ObjectMapper objectMapper = new ObjectMapper();

            ApiResponseDto apiResponseDto = objectMapper.readValue(ex.getResponseBodyAsString(), ApiResponseDto.class);
            response = new ResponseEntity<>(apiResponseDto,ex.getStatusCode());
            return response;
         }
      }

      public ResponseEntity<?> deleteStudent(Long studentId)
      {
         ResponseEntity<?> response;
         String URL = studentBaseUrl+"/delete/{studentId}";
         try
         {
            response = 
            restTemplate.exchange(URL, HttpMethod.DELETE, null, Void.class, studentId);

            return response;
         }
         catch(HttpClientErrorException ex)
         {
            ObjectMapper objectMapper = new ObjectMapper();

            ApiResponseDto apiResponseDto = objectMapper.readValue(ex.getResponseBodyAsString(), ApiResponseDto.class);
            return new ResponseEntity<>(apiResponseDto,ex.getStatusCode());
         }
      }
      

}
