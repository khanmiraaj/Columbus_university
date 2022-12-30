package com.cu.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cu.dto.StudentDto;
import com.cu.dto.StudentResponseDto;
import com.cu.entity.Student;
import com.cu.repository.StudentRepository;

@Service
public class StudentManagementServcie {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public StudentResponseDto registerStudent(StudentDto studentDto) {
		StudentResponseDto responseDto = null;
		Student student = null;
		student = new Student();

		BeanUtils.copyProperties(studentDto, student);
		responseDto = new StudentResponseDto();

		try {
			studentRepository.saveAndFlush(student);
			responseDto.setStatusCode("S0000");
			responseDto.setDescription("student registedred successfully");
		} catch (Exception e) {
			responseDto.setStatusCode("F0000");
			responseDto.setDescription("Failed to register student");
		}
		return responseDto;

	}

}
