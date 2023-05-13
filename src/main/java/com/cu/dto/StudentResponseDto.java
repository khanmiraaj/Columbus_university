package com.cu.dto;

public class StudentResponseDto {

	private String statusCode;

	private String description;

	private StudentDto studentDto;

	private FeeDetailsDto feeDetailsDto;
	
	private StudentResultDto studentResultDto;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StudentDto getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}

	public FeeDetailsDto getFeeDetailsDto() {
		return feeDetailsDto;
	}

	public void setFeeDetailsDto(FeeDetailsDto feeDetailsDto) {
		this.feeDetailsDto = feeDetailsDto;
	}
	
	

	public StudentResultDto getStudentResultDto() {
		return studentResultDto;
	}

	public void setStudentResultDto(StudentResultDto studentResultDto) {
		this.studentResultDto = studentResultDto;
	}

	@Override
	public String toString() {
		return "StudentResponseDto [statusCode=" + statusCode + ", description=" + description + ", studentDto="
				+ studentDto + "]";
	}

}
