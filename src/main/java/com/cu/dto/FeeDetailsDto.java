package com.cu.dto;

import java.util.Date;

public class FeeDetailsDto {

	private String universityRollNo;

	private double feeAmount;

	private double lateFee;

	private String semester;

	private String programName;

	private String lastDate;

	private String status;

	public String getUniversityRollNo() {
		return universityRollNo;
	}

	public void setUniversityRollNo(String universityRollNo) {
		this.universityRollNo = universityRollNo;
	}

	public double getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(double feeAmount) {
		this.feeAmount = feeAmount;
	}

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FeeDetailsDto [universityRollNo=" + universityRollNo + ", feeAmount=" + feeAmount + ", lateFee="
				+ lateFee + ", lastDate=" + lastDate + "]";
	}

}
