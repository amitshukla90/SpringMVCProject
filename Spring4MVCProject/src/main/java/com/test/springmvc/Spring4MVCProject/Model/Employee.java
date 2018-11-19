package com.test.springmvc.Spring4MVCProject.Model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {
	
	@Size(min = 4, max = 20)
	private String firstName;
	
	private String lastName;
	
	@NotNull @Max(5000)
	private int empid;
	
	@NotNull @Min(18) @Max(60)
	private int age;
	
	private String role;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, int empid, int age, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empid = empid;
		this.age = age;
		this.role = role;
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
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
