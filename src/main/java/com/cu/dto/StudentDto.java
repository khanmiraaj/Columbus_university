package com.cu.dto;

public class StudentDto {

	private String firstName;

	private String lastName;

	private String course;

	private String dateOfBirth;

	private String semester;

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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
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

	@Override
	public String toString() {
		return "StudentDto [firstName=" + firstName + ", lastName=" + lastName + ", course=" + course + ", dateOfBirth="
				+ dateOfBirth + ", semester=" + semester + "]";
	}
	
	
	

}
