package com.cu.service;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cu.dto.StudentDto;
import com.cu.dto.StudentResponseDto;
import com.cu.dto.StudentSignInDto;
import com.cu.entity.Student;
import com.cu.repository.StudentRepository;

@Service
public class StudentManagementServcie {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public StudentResponseDto registerStudent(StudentDto studentDto) {
		StudentResponseDto responseDto = null;
		Optional<Student> optionalStudent = null;
		responseDto = new StudentResponseDto();
		Student student = null;
		student = new Student();

		optionalStudent = studentRepository.findByUniversityRollNo(studentDto.getUniversityRollNo());

		if (optionalStudent.isPresent()) {
			responseDto.setStatusCode("F0000");
			responseDto.setDescription("You Are  Already Registered With Us");
			return responseDto;

		}

		BeanUtils.copyProperties(studentDto, student);

		try {
			studentRepository.saveAndFlush(student);
			responseDto.setStatusCode("S0000");
			responseDto.setDescription("student registedred successfully");
		} catch (Exception e) {
			responseDto.setStatusCode("F0001");
			responseDto.setDescription("Failed to register student");
		}
		return responseDto;

	}

	@Transactional
	public StudentResponseDto validateStudent(StudentSignInDto studentSignInDto) {
		StudentResponseDto studentResponseDto = new StudentResponseDto();
		String universityRollNo = studentSignInDto.getUniversityRollNo();
		String password = studentSignInDto.getPassword();
		Optional<Student> optionalStudent = null;
		Student student = null;
		optionalStudent = studentRepository.findByUniversityRollNo(universityRollNo);
		if (optionalStudent.isPresent()) {
			student = optionalStudent.get();
			if (StringUtils.equalsIgnoreCase(password, student.getPassword())) {
				studentResponseDto.setStatusCode("S0001");
				studentResponseDto.setDescription("login successful/valid credential");
			}
		} else {
			studentResponseDto.setStatusCode("F0002");
			studentResponseDto.setDescription("login Failed/Invalid credential");
		}
		return studentResponseDto;
	}

}
