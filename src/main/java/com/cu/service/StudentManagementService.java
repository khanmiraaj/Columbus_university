package com.cu.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cu.dto.FeeDetailsDto;
import com.cu.dto.ResetPasswordDto;
import com.cu.dto.StudentDto;
import com.cu.dto.StudentQueryDto;
import com.cu.dto.StudentResponseDto;
import com.cu.dto.StudentResultDto;
import com.cu.dto.StudentSignInDto;
import com.cu.dto.SubjectDetailsDto;
import com.cu.entity.Student;
import com.cu.entity.StudentFeeDetails;
import com.cu.entity.StudentQuery;
import com.cu.entity.StudentResult;
import com.cu.helper.EmailUtils;
import com.cu.repository.StudentFeesDetailsRepository;
import com.cu.repository.StudentQueryRepository;
import com.cu.repository.StudentRepository;
import com.cu.repository.StudentResultRepository;

@Service
public class StudentManagementService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentFeesDetailsRepository studentFeesDetailsRepository;

	@Autowired
	private StudentResultRepository studentResultRepository;

	@Autowired
	private StudentQueryRepository studentQueryRepository;
	
	@Autowired
	private EmailUtils emailUtils;

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
			String body = "Dear " + studentDto.getFirstName()
					+ "\nyou are successfully Registered with us\n" + "your username:"
					+ studentDto.getUniversityRollNo() + "\n" + "Password:" + studentDto.getUniversityRollNo()+"\n\nyou can use this credential to login to Columbus University student generic service portal\n\n Regards,\n Columbus University";
			String to=studentDto.getEmailAddress();
			
			String subject="CU Registration Successfull";
			
			emailUtils.sendEmail(to, subject, body);
			
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

	@Transactional
	public StudentResponseDto getStudentDetails(String universityRollNo) {
		Optional<Student> optionalStudent = null;
		StudentDto studentDto = new StudentDto();
		StudentResponseDto studentResponseDto = new StudentResponseDto();
		optionalStudent = studentRepository.findByUniversityRollNo(universityRollNo);
		if (optionalStudent.isPresent()) {
			BeanUtils.copyProperties(optionalStudent.get(), studentDto);
			studentResponseDto.setStudentDto(studentDto);
			studentResponseDto.setStatusCode("S0004");
			studentResponseDto.setDescription("Success");
			return studentResponseDto;

		} else {
			studentResponseDto.setStatusCode("F0005");
			studentResponseDto.setDescription("Student not exist");
		}

		return studentResponseDto;
	}

	@Transactional(readOnly = false)
	public StudentResponseDto getStudentFeeDetails(String universityRollNo) {
		Optional<StudentFeeDetails> optionalStudentFee = null;
		FeeDetailsDto feeDetailsDto = new FeeDetailsDto();
		StudentResponseDto studentResponseDto = new StudentResponseDto();
		optionalStudentFee = studentFeesDetailsRepository.findByUniversityRollNo(universityRollNo);
		Optional<Student> optionalStudent = studentRepository.findByUniversityRollNo(universityRollNo);
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
	      
	  //  System.out.println("Date Format with dd MMMM yyyy : "+strDate); 
		if (optionalStudentFee.isPresent()) {
			BeanUtils.copyProperties(optionalStudentFee.get(), feeDetailsDto);
			Date date=optionalStudentFee.get().getLastDate();
			String lastDate = formatter.format(date);
			feeDetailsDto.setLastDate(lastDate);
			feeDetailsDto.setSemester(optionalStudent.get().getSemester());
			feeDetailsDto.setProgramName(optionalStudent.get().getCourseName());
			studentResponseDto.setFeeDetailsDto(feeDetailsDto);
			studentResponseDto.setStatusCode("S0005");
			studentResponseDto.setDescription("Success");
			return studentResponseDto;

		} else {
			studentResponseDto.setStatusCode("F0006");
			studentResponseDto.setDescription("Student not exist");
		}

		return studentResponseDto;
	}

	@Transactional
	public StudentResponseDto updateStudentFeeDetails(FeeDetailsDto feeDetailsDto) {
		StudentResponseDto studentResponseDto = new StudentResponseDto();
		String universityRollNo = feeDetailsDto.getUniversityRollNo();
		double feeAmount = feeDetailsDto.getFeeAmount();
		Optional<StudentFeeDetails> optionalStudentFee = null;
		StudentFeeDetails studentFeeDetails = null;
		optionalStudentFee = studentFeesDetailsRepository.findByUniversityRollNo(universityRollNo);

		if (optionalStudentFee.isPresent()) {
			if (feeAmount == optionalStudentFee.get().getFeeAmount()) {

				studentFeeDetails = optionalStudentFee.get();
				studentFeeDetails.setFeeAmount(0);
				studentFeeDetails.setPaidDate(new Date());
				studentFeeDetails.setStatus("paid successfully");
				studentFeesDetailsRepository.saveAndFlush(studentFeeDetails);
				studentResponseDto.setStatusCode("S0006");
				studentResponseDto.setDescription("Fee Paid Successfully");
				return studentResponseDto;

			}
			if (feeAmount < optionalStudentFee.get().getFeeAmount()
					|| feeAmount > optionalStudentFee.get().getFeeAmount()) {
				studentResponseDto.setStatusCode("F0007");
				studentResponseDto.setDescription("Please Verify Fee Amount");
				return studentResponseDto;
			}

		}
		return studentResponseDto;

	}

	@Transactional
	public StudentResponseDto getStudentResult(String universityRollNo) {
		StudentResponseDto studentResponseDto = new StudentResponseDto();
		StudentResultDto studentResultDto = new StudentResultDto();
		SubjectDetailsDto subjectDetailsDto = null;
		List<StudentResult> studentResults = null;
		List<SubjectDetailsDto> subjectDetailsDtos = new ArrayList<>();
		studentResults = studentResultRepository.findByUniversityRollNo(universityRollNo);
		Student student = studentRepository.findByUniversityRollNo(universityRollNo).get();

		if (!studentResults.isEmpty()) {

			for (StudentResult studentResult : studentResults) {
				subjectDetailsDto = new SubjectDetailsDto();
				subjectDetailsDto.setSubjectName(studentResult.getSubjectName());
				subjectDetailsDto.setSubjectCode(studentResult.getSubjectCode());
				subjectDetailsDto.setGrade(studentResult.getGrade());
				subjectDetailsDto.setMarksObtained(studentResult.getMarksObtained());
				subjectDetailsDto.setFullMarks(studentResult.getFullMarks());
				subjectDetailsDtos.add(subjectDetailsDto);
				studentResultDto.setSubjectMarksDetails(subjectDetailsDtos);

			}
			Double percentage = studentResultRepository.getPercentage(universityRollNo);

			studentResultDto.setPercentage(String.valueOf(percentage));
			studentResultDto.setFatherName(student.getFatherName());
			studentResultDto.setMotherName(student.getMotherName());
			studentResultDto.setSemester(student.getSemester());
			studentResultDto.setUniversityRollNo(universityRollNo);
			studentResultDto.setName(student.getFirstName() + " " + student.getLastName());
			if (student.getCourseName().equalsIgnoreCase("MCA")) {
				studentResultDto.setProgrameName("Master Of Computer Applications(MCA)");
			}

			if (student.getCourseName().equalsIgnoreCase("BCA")) {
				studentResultDto.setProgrameName("Bachelors Of Computer Applications(BCA)");
			}
			studentResponseDto.setStatusCode("S0007");
			studentResponseDto.setDescription("Success");
			studentResponseDto.setStudentResultDto(studentResultDto);

		}

		return studentResponseDto;
	}

	@Transactional
	public StudentResponseDto saveStudentQuery(StudentQueryDto studentQueryDto) {
		StudentResponseDto studentResponseDto = new StudentResponseDto();
		StudentQuery studentQuery = new StudentQuery();
		BeanUtils.copyProperties(studentQueryDto, studentQuery);
		studentQuery.setStatus("raised successfully");
		studentQueryRepository.saveAndFlush(studentQuery);
		studentResponseDto.setStatusCode("S0008");
		studentResponseDto.setDescription("Query Raised Successfully");

		return studentResponseDto;
	}

}
