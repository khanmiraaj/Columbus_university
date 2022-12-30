package com.cu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cu.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
	Optional<Student> findByUniversityRollNo(String universityRollNo);

}
