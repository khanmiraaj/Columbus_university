package com.cu.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_fee_details")
public class StudentFeeDetails {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	@Column(name = "university_roll_no")
	protected String universityRollNo;

	@Column(name = "fee_amount")
	protected double feeAmount;

	@Column(name = "late_fee")
	protected double lateFee;

	@Column(name = "last_date")
	protected Date lastDate;

	@Column(name = "paid_date")
	protected Date paidDate;

	@Column(name = "status")
	protected String status;

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

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StudentFeeDetails [id=" + id + ", universityRollNo=" + universityRollNo + ", feeAmount=" + feeAmount
				+ ", lateFee=" + lateFee + ", lastDate=" + lastDate + "]";
	}

}
