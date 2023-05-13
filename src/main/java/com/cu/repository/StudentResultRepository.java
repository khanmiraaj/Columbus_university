package com.cu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cu.entity.StudentResult;

import jakarta.websocket.server.PathParam;

public interface StudentResultRepository extends JpaRepository<StudentResult, Integer>{
	
	List<StudentResult> findByUniversityRollNo(String universityRollNo);
	
	@Query(value = "select sum(marks_obtained)/6 from student_result where university_roll_no=:roll_no", nativeQuery = true)
	Double getPercentage(@PathParam("roll_no") String roll_no);

}
