package com.rovira.StudentProducer.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rovira.StudentProducer.dto.CreateStudentRequestDto;
import com.rovira.StudentProducer.dto.CreateStudentResponseDto;
import com.rovira.StudentProducer.dto.GetStudentDto;
import com.rovira.StudentProducer.dto.UpdateStudentRequestDto;
import com.rovira.StudentProducer.dto.UpdateStudentResponseDto;
import com.rovira.StudentProducer.entity.Student;
import com.rovira.StudentProducer.exceptions.InvalidInputException;
import com.rovira.StudentProducer.exceptions.MandatoryFieldNotSpecifiedException;
import com.rovira.StudentProducer.exceptions.RecordNotFoundException;
import com.rovira.StudentProducer.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service(value = "studentService")
@RequiredArgsConstructor 
public class StudentServiceImpl implements StudentService{

    @Autowired
    private final StudentRepository studentRepository;

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto createStudentRequestDto){
        CreateStudentResponseDto createStudentResponseDto = new CreateStudentResponseDto();
        Student student  = new Student();

        if(createStudentRequestDto.getCourse() != null && !createStudentRequestDto.getCourse().isBlank())
        {
            student.setCourse(createStudentRequestDto.getCourse());
        }
        else
        {
            throw new MandatoryFieldNotSpecifiedException("Mandatory filed course is not specified");
        }
        
        if(createStudentRequestDto.getFirstName() !=null && !createStudentRequestDto.getFirstName().isBlank())
        {
            student.setFirstName(createStudentRequestDto.getFirstName());
        }
        else
        {
            throw new MandatoryFieldNotSpecifiedException("Mandatory field first name is not specified");
        }

        if(createStudentRequestDto.getLastName() !=null && !createStudentRequestDto.getLastName().isBlank())
        {
            student.setLastName(createStudentRequestDto.getLastName());
        }
        else
        {
            throw new MandatoryFieldNotSpecifiedException("mandatory field last name is not specified");
        }

        if(createStudentRequestDto.getDateOfBirth() !=null)
        {
            if(createStudentRequestDto.getDateOfBirth().isAfter(LocalDate.now()))
            {
                throw new InvalidInputException("Date of birth must be less than current date");
            }
            student.setDateOfBirth(createStudentRequestDto.getDateOfBirth());
        }
        else
        {
            throw new MandatoryFieldNotSpecifiedException("Mandatory field date of birth is not specified");
        }
        
        if(createStudentRequestDto.getEmail() != null && !createStudentRequestDto.getEmail().isBlank())
        {
            student.setEmail(createStudentRequestDto.getEmail());
        }
        else
        {
            throw new MandatoryFieldNotSpecifiedException("Mandatory field email is not specified");
        }
        
        if(createStudentRequestDto.getPercentage() != null)
        {
            if(createStudentRequestDto.getPercentage()<=0)
            {
                throw new InvalidInputException("Percentage must be greater than 0");
            }
            if(createStudentRequestDto.getPercentage()>100)
            {
                throw new InvalidInputException("Percentage must be less than or equal to 100");
            }
            student.setPercentage(createStudentRequestDto.getPercentage());
        }
        else
        {
            throw new MandatoryFieldNotSpecifiedException("Mandatory field percentage is not specified");
        }
        
        if(createStudentRequestDto.getPhoneNumber() !=null || createStudentRequestDto.getPhoneNumber().isBlank())
        {
            student.setPhoneNumber(createStudentRequestDto.getPhoneNumber());
        }
        else
        {
            throw new MandatoryFieldNotSpecifiedException("Mandatory field phone number is not specified");
        }
       
        if(createStudentRequestDto.getGender() != null)
        {
            try{
            student.setGender(createStudentRequestDto.getGender());
            }
            catch(Exception ex)
            {
                throw new InvalidInputException(ex.getMessage());
            }
            
        }
        else
        {
            throw new MandatoryFieldNotSpecifiedException("Mandatory field gender is not specified");
        }
        

        Student savedStudent = studentRepository.save(student);
        createStudentResponseDto.setFirstName(savedStudent.getFirstName());
        createStudentResponseDto.setStudentId(savedStudent.getStudentId());
        return createStudentResponseDto;
    }

    public GetStudentDto getStudentById(Long studentId)
    {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RecordNotFoundException("Student not found with id: " + studentId));
        GetStudentDto getStudentDto = new GetStudentDto();
        getStudentDto.setStudentId(student.getStudentId());
        getStudentDto.setFirstName(student.getFirstName());
        getStudentDto.setLastName(student.getLastName());
        getStudentDto.setEmail(student.getEmail());
        getStudentDto.setCourse(student.getCourse());
        getStudentDto.setPercentage(student.getPercentage());
        getStudentDto.setPhoneNumber(student.getPhoneNumber());
        getStudentDto.setGender(student.getGender());
        getStudentDto.setDateOfBirth(student.getDateOfBirth());
        return getStudentDto;
    }

    public UpdateStudentResponseDto updateStudent(UpdateStudentRequestDto updateStudentRequestDto, Long studentId)
    {
        UpdateStudentResponseDto updateStudentResponseDto = new UpdateStudentResponseDto();
        Student student = studentRepository.findById(studentId)
                                                    .orElseThrow(()->
                                                    new RecordNotFoundException("Record not found for studentId: "+studentId));

        if(updateStudentRequestDto.getCourse() != null && !updateStudentRequestDto.getCourse().isBlank())
        {
            student.setCourse(updateStudentRequestDto.getCourse());
        }
        if(updateStudentRequestDto.getEmail() != null && !updateStudentRequestDto.getEmail().isBlank())
        {
            student.setEmail(updateStudentRequestDto.getEmail());
        }
        if(updateStudentRequestDto.getGender() != null)
        {
            student.setGender(updateStudentRequestDto.getGender());
        }
        if(updateStudentRequestDto.getFirstName() != null && !updateStudentRequestDto.getFirstName().isBlank())
        {
            student.setFirstName(updateStudentRequestDto.getFirstName());
        }
        if(updateStudentRequestDto.getLastName() != null && !updateStudentRequestDto.getLastName().isBlank())
        {
            student.setLastName(updateStudentRequestDto.getLastName());
        }
        if(updateStudentRequestDto.getPhoneNumber() !=null && !updateStudentRequestDto.getPhoneNumber().isBlank())
        {
            student.setPhoneNumber(updateStudentRequestDto.getPhoneNumber());
        }
        if(updateStudentRequestDto.getPercentage() != null )
        {
            if(updateStudentRequestDto.getPercentage()<=0)
            {
                throw new InvalidInputException("Percentage must be greater than 0");
            }
            if(updateStudentRequestDto.getPercentage()>100)
            {
                throw new InvalidInputException("Percentage must be less than or equal to 100");
            }
            student.setPercentage(updateStudentRequestDto.getPercentage());
        }
        if(updateStudentRequestDto.getDateOfBirth() !=null)
        {
            if(updateStudentRequestDto.getDateOfBirth().isAfter(LocalDate.now()))
            {
                throw new InvalidInputException("Date of birth must be less than current date");
            }
            student.setDateOfBirth(updateStudentRequestDto.getDateOfBirth());
        }
        studentRepository.save(student);
        updateStudentResponseDto.setFirstName(student.getFirstName());
        updateStudentResponseDto.setStudentId(student.getStudentId());
        

        return updateStudentResponseDto;
    }

    public void deleteStudent(Long studentId)
    {
        if(studentRepository.existsById(studentId))
        {
            studentRepository.deleteById(studentId);
        }
        else
        {
            throw new RecordNotFoundException("Record not found for studentId: "+studentId);
        }
    }
    
}
