package com.cu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cu.entity.StudentFeeDetails;

public interface StudentFeesDetailsRepository extends JpaRepository<StudentFeeDetails, Integer>{
	
	
	Optional<StudentFeeDetails> findByUniversityRollNo(String universityRollNo);
	

}
