package com.test.springmvc.Spring4MVCProject.Iservice;

import com.test.springmvc.Spring4MVCProject.Model.Employee;

public interface ISpringMVC4Service {
	
	public void saySomthing();
	
	public String insertEmployee(Employee emp);

	public String searchEmployee(int employeeId);

}
