package com.cu.dto;

public class StudentSignInDto {

	private String universityRollNo;

	private String password;

	public String getUniversityRollNo() {
		return universityRollNo;
	}

	public void setUniversityRollNo(String universityRollNo) {
		this.universityRollNo = universityRollNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "StudentSignInDto [universityRollNo=" + universityRollNo + ", password=" + password + "]";
	}

}
