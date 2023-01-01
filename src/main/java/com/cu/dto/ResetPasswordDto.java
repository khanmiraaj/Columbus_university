package com.cu.dto;

public class ResetPasswordDto {

	private String newPassword;
	private String confirmPassword;
	private String universityRollNo;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUniversityRollNo() {
		return universityRollNo;
	}

	public void setUniversityRollNo(String universityRollNo) {
		this.universityRollNo = universityRollNo;
	}

	@Override
	public String toString() {
		return "ResetPasswordDto [newPassword=" + newPassword + ", confirmPassword=" + confirmPassword
				+ ", universityRollNo=" + universityRollNo + "]";
	}

}
