package com.cu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name = "student_result")
public class StudentResult {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	@Column(name = "university_roll_no")
	protected String universityRollNo;

	@Column(name = "marks_obtained")
	protected int marksObtained;

	@Column(name = "subject_code")
	protected String subjectCode;

	@Column(name = "subject_name")
	protected String subjectName;

	@Column(name = "full_marks")
	protected int fullMarks;

	@Column(name = "grade")
	private String grade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUniversityRollNo() {
		return universityRollNo;
	}

	public void setUniversityRollNo(String universityRollNo) {
		this.universityRollNo = universityRollNo;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public int getFullMarks() {
		return fullMarks;
	}

	public void setFullMarks(int fullMarks) {
		this.fullMarks = fullMarks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "StudentResult [id=" + id + ", universityRollNo=" + universityRollNo + ", marksObtained=" + marksObtained
				+ ", subjectCode=" + subjectCode + ", fullMarks=" + fullMarks + ", grade=" + grade + "]";
	}

}
