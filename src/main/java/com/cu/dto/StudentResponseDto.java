package com.cu.dto;

public class StudentResponseDto {

	private String statusCode;

	private String description;

	private StudentDto studentDto;

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

	@Override
	public String toString() {
		return "StudentResponseDto [statusCode=" + statusCode + ", description=" + description + ", studentDto="
				+ studentDto + "]";
	}

}
