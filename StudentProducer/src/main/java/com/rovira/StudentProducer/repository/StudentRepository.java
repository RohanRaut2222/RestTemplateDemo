package com.rovira.StudentProducer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rovira.StudentProducer.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
