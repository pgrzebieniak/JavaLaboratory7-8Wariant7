package com.keylesson.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name = "Duty")
public class Duty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Duty_ID", nullable = false)
	private int dutyId;

	@Column(name = "Day", nullable = false, unique = true, length = 20)
	private int day;

	@Column(name = "Month")
	private String month;

	@Column(name = "HourFrom",length = 2)
	private int hourFrom;

	@Column(name = "HourTo",length = 2)
	private int hourTo;

	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "EMPLOYEE_ID", nullable = false)
	private Employee employee;

	public Duty() {
	}

	public Duty(int day, String month, int hourFrom,int hourTo,int year ) {
		this.day = day;
		this.month = month;
		this.hourFrom = hourFrom;
		this.hourTo = hourTo;
	}

	public int getDutyId() {
		return dutyId;
	}

	public void setDutyId(int orderId) {
		this.dutyId = dutyId;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day =day;
	}

	public String getMonth(){ return month; }

	public void setMonth(String month) {
		this.month = month;
	}

	public int gethourFrom() {
		return hourFrom;
	}

	public void sethourFrom(int hourFrom) {
		this.hourFrom =hourFrom;
	}

	public int gethourTo() {
		return hourTo;
	}

	public void sethourTo(int hourTo) {
		this.hourTo =hourTo;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void getEmployee(Employee employee) {
		this.employee = employee;
	}

}
