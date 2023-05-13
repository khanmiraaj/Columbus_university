package com.cu.dto;

public class AdminResponseDto {

	private String status;

	private String description;

	private AdminDto adminDto;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AdminDto getAdminDto() {
		return adminDto;
	}

	public void setAdminDto(AdminDto adminDto) {
		this.adminDto = adminDto;
	}

	@Override
	public String toString() {
		return "AdminResponseDto [status=" + status + ", description=" + description + ", adminDto=" + adminDto + "]";
	}

}
