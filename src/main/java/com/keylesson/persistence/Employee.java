package com.keylesson.persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID", nullable = false)
	private int customerId;

	@Column(name = "LastName", nullable = false, length = 25)
	private String lastName;

	@Column(name = "NAME", nullable = false, length = 20)
	private String name;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	private Set<Duty> duty = new HashSet<Duty>(0);

	public Employee() {
	}

	public Employee(String lastName, String name) {
		this.lastName = lastName;
		this.name = name;
	}

	public int getEmployeeId() {
		return customerId;
	}

	public void setEmployeeId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Duty> getDuty() {
		return duty;
	}

	public void setDuty(Set<Duty> duty) {
		this.duty = duty;
	}

}
