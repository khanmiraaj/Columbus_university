package com.cu.dto;

public class StudentQueryDto {

	private String universityRollNo;

	private String priority;

	private String query;

	private String status;

	public String getUniversityRollNo() {
		return universityRollNo;
	}

	public void setUniversityRollNo(String universityRollNo) {
		this.universityRollNo = universityRollNo;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StudentQueryDto [universityRollNo=" + universityRollNo + ", priority=" + priority + ", query=" + query
				+ ", status=" + status + "]";
	}

}
