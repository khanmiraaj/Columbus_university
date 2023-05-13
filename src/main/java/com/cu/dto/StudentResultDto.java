package com.cu.dto;

import java.util.List;

public class StudentResultDto {

	private String universityRollNo;

	private String name;

	private String programeName;

	private String fatherName;

	private String motherName;

	private String percentage;

	private String semester;

	private List<SubjectDetailsDto> subjectMarksDetails;

	public String getUniversityRollNo() {
		return universityRollNo;
	}

	public void setUniversityRollNo(String universityRollNo) {
		this.universityRollNo = universityRollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProgrameName() {
		return programeName;
	}

	public void setProgrameName(String programeName) {
		this.programeName = programeName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public List<SubjectDetailsDto> getSubjectMarksDetails() {
		return subjectMarksDetails;
	}

	public void setSubjectMarksDetails(List<SubjectDetailsDto> subjectMarksDetails) {
		this.subjectMarksDetails = subjectMarksDetails;
	}

}
