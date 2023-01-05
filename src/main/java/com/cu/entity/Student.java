package com.cu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "university_roll_no")
	protected String universityRollNo;

	@Column(name = "first_nm")
	protected String firstName;

	@Column(name = "last_nm")
	protected String lastName;

	@Column(name = "dob")
	protected String dateOfBirth;

	@Column(name = "semester")
	protected String semester;

	@Column(name = "course")
	protected String course;

	@Column(name = "course_nm")
	protected String courseName;

	@Column(name = "password")
	protected String password;

	public String getUniversityRollNo() {
		return universityRollNo;
	}

	public void setUniversityRollNo(String universityRollNo) {
		this.universityRollNo = universityRollNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [universityRollNo=" + universityRollNo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", semester=" + semester + ", course=" + course + ", courseName="
				+ courseName + ", password=" + password + "]";
	}

}
