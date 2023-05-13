package com.cu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cu.dto.FeeDetailsDto;
import com.cu.dto.ResetPasswordDto;
import com.cu.dto.StudentDto;
import com.cu.dto.StudentQueryDto;
import com.cu.dto.StudentResponseDto;
import com.cu.dto.StudentSignInDto;
import com.cu.service.StudentManagementService;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

	@Autowired
	private StudentManagementService studentManagementService;

	@PostMapping(value = "/new-student", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerStudent(@RequestBody StudentDto studentDto) {

		StudentResponseDto studentResponseDto = studentManagementService.registerStudent(studentDto);
		return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
	}

	@PostMapping(value = "/validate-student", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> validateStudent(@RequestBody StudentSignInDto studentSignInDto) {

		StudentResponseDto studentResponseDto = studentManagementService.validateStudent(studentSignInDto);

		return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
	}

	@PostMapping(value = "/reset-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordDto resetPasswordDto) {
		StudentResponseDto studentResponseDto = studentManagementService.resetPassword(resetPasswordDto);
		return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
	}

	@PostMapping(value = "/update-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePassword(@RequestBody ResetPasswordDto resetPasswordDto) {
		StudentResponseDto studentResponseDto = studentManagementService.updatePassword(resetPasswordDto);
		return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
	}
	
	
	@GetMapping("/view_profile/{universityRollNo}")
	public ResponseEntity<StudentResponseDto> getStudentDetails(
			@PathVariable("universityRollNo") String universityRollNo) {
		StudentResponseDto studentResponseDto = studentManagementService.getStudentDetails(universityRollNo);

		return ResponseEntity.ok(studentResponseDto);
	}

	@GetMapping("/view_profile/{universityRollNo}/payfees")
	public ResponseEntity<StudentResponseDto> getStudentFeeDetails(
			@PathVariable("universityRollNo") String universityRollNo) {
		StudentResponseDto studentResponseDto = studentManagementService.getStudentFeeDetails(universityRollNo);
		return ResponseEntity.ok(studentResponseDto);
	}
	
	@PostMapping("/view_profile/update_fee")
	public ResponseEntity<StudentResponseDto> updateFeeDetails(@RequestBody FeeDetailsDto feeDetailsDto) {
		StudentResponseDto studentResponseDto = studentManagementService.updateStudentFeeDetails(feeDetailsDto);
		return ResponseEntity.ok(studentResponseDto);

	}
	
	@GetMapping("/view_profile/{universityRollNo}/result")
	public ResponseEntity<StudentResponseDto> getStudentResult(
			@PathVariable("universityRollNo") String universityRollNo) {

		StudentResponseDto studentResponseDto = studentManagementService.getStudentResult(universityRollNo);
		return ResponseEntity.ok(studentResponseDto);

	}
	
	@PostMapping("/view_profile/save_query")
	public ResponseEntity<StudentResponseDto> saveStudentQuery(@RequestBody StudentQueryDto studentQueryDto) {
		StudentResponseDto studentResponseDto = studentManagementService.saveStudentQuery(studentQueryDto);

		return ResponseEntity.ok(studentResponseDto);
	}
	

}
