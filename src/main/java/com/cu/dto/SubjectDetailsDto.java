package com.cu.dto;

public class SubjectDetailsDto {

	private String subjectCode;

	private String subjectName;

	private int fullMarks;

	private int marksObtained;

	private String grade;

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getFullMarks() {
		return fullMarks;
	}

	public void setFullMarks(int fullMarks) {
		this.fullMarks = fullMarks;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "SubjectDetailsDto [subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", fullMarks="
				+ fullMarks + ", marksObtained=" + marksObtained + ", grade=" + grade + "]";
	}

}
