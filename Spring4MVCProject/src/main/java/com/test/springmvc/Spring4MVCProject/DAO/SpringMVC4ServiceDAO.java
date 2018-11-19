package com.test.springmvc.Spring4MVCProject.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;
import com.test.springmvc.Spring4MVCProject.IDAO.ISpringMVC4ServiceDAO;
import com.test.springmvc.Spring4MVCProject.Model.Employee;

@Repository
public class SpringMVC4ServiceDAO implements ISpringMVC4ServiceDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void saySomthing() {
		System.out.println("My JDBC Connections ::"+ jdbcTemplate);
		System.out.println("This is my DAO class");
	}

	@Override
	public String insertEmployee(Employee emp) {
		String query = "insert into Employee (id,firstName,lastName,age,role) values"
				+ "(?,?,?,?,?)";
		 int response = jdbcTemplate.update(query, new Object[] {
				 emp.getEmpid(),emp.getFirstName(),emp.getLastName(),
				 emp.getAge(),emp.getRole()});
		 if(response > 0) {
			 return "Employee added Successfully";
		 }else {
			 return "Employee was not added"; 
		 }
		
	}

	@Override
	public String insertEmployee(int employeeId) {
		String query = " SELECT firstName from Employee where id = ?";
		String firstName = jdbcTemplate.queryForObject(query, new Object[] {employeeId},String.class);
		return firstName;
	}

}
