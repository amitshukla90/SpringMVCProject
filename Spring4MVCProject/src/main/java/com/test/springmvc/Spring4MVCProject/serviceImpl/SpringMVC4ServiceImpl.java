package com.test.springmvc.Spring4MVCProject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springmvc.Spring4MVCProject.IDAO.ISpringMVC4ServiceDAO;
import com.test.springmvc.Spring4MVCProject.Iservice.ISpringMVC4Service;
import com.test.springmvc.Spring4MVCProject.Model.Employee;

@Service
public class SpringMVC4ServiceImpl  implements ISpringMVC4Service{
	
	@Autowired
	ISpringMVC4ServiceDAO iSpringMVC4ServiceDAO;

	@Override
	public void saySomthing() {
		System.out.println("In the service class");
		iSpringMVC4ServiceDAO.saySomthing();
		
	}

	@Override
	public String insertEmployee(Employee emp) {
		return iSpringMVC4ServiceDAO.insertEmployee(emp);
	}

	@Override
	public String searchEmployee(int employeeId) {
		return iSpringMVC4ServiceDAO.insertEmployee(employeeId);
	}

}
