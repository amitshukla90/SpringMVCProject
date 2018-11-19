package com.test.springmvc.Spring4MVCProject.IDAO;

import com.test.springmvc.Spring4MVCProject.Model.Employee;

public interface ISpringMVC4ServiceDAO {
	
	public void saySomthing();

	public String insertEmployee(Employee emp);

	public String insertEmployee(int employeeId);

}
