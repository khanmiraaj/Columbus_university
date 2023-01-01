package com.cu.service;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cu.dto.ResetPasswordDto;
import com.cu.dto.StudentDto;
import com.cu.dto.StudentResponseDto;
import com.cu.dto.StudentSignInDto;
import com.cu.entity.Student;
import com.cu.repository.StudentRepository;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@Service
public class StudentManagementService {

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
			responseDto.setDescription("You Are  ALready Registered With Us");
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
		StudentDto studentDto = new StudentDto();
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
				studentDto.setUniversityRollNo(student.getUniversityRollNo());
				studentDto.setSemester(student.getSemester());
				studentDto.setCourse(student.getCourse());
				studentDto.setFirstName(student.getFirstName());
				studentDto.setLastName(student.getLastName());
				studentDto.setDateOfBirth(student.getDateOfBirth());
				studentDto.setCourseName(student.getCourseName());
				studentResponseDto.setStudentDto(studentDto);

				return studentResponseDto;
			} else {
				studentResponseDto.setStatusCode("F0002");
				studentResponseDto.setDescription("login Failed/Invalid credential");
				return studentResponseDto;
			}
		} else {
			studentResponseDto.setStatusCode("F0002");
			studentResponseDto.setDescription("login Failed/Invalid credential");
		}
		return studentResponseDto;
	}

	@Transactional(readOnly = false)
	public StudentResponseDto resetPassword(ResetPasswordDto resetPasswordDto) {
		StudentResponseDto studentResponseDto = new StudentResponseDto();
		Optional<Student> optionalStudent = null;
		StudentDto studentDto = new StudentDto();
		optionalStudent = studentRepository.findByUniversityRollNo(resetPasswordDto.getUniversityRollNo());

		if (optionalStudent.isPresent()) {
			studentResponseDto.setStatusCode("S0002");
			studentResponseDto.setDescription("Success");
			studentDto.setUniversityRollNo(resetPasswordDto.getUniversityRollNo());
			studentResponseDto.setStudentDto(studentDto);
		} else {
			studentResponseDto.setStatusCode("F0003");
			studentResponseDto.setDescription("Please Enter a valid UniversityROllNo");
		}

		return studentResponseDto;
	}

	@Transactional
	public StudentResponseDto updatePassword(ResetPasswordDto resetPasswordDto) {
		Optional<Student> optionalStudent = null;
		StudentResponseDto studentResponseDto = new StudentResponseDto();
		Student student = null;
		String newPassword = resetPasswordDto.getNewPassword();
		String confirmPassword = resetPasswordDto.getConfirmPassword();

		if (StringUtils.equals(newPassword, confirmPassword)) {
			optionalStudent = studentRepository.findByUniversityRollNo(resetPasswordDto.getUniversityRollNo());
			student = optionalStudent.get();
			student.setPassword(confirmPassword);
			try {
				student = studentRepository.saveAndFlush(student);
				studentResponseDto.setStatusCode("S0003");
				studentResponseDto.setDescription("Password updated successfully");
				return studentResponseDto;
			} catch (Exception e) {
				studentResponseDto.setStatusCode("F0004");
				studentResponseDto.setDescription("Failed to update password");
				return studentResponseDto;
			}
		} else {
			studentResponseDto.setStatusCode("F0004");
			studentResponseDto.setDescription("Failed to update password");
		}

		return studentResponseDto;

	}

}
