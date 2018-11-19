package com.test.springmvc.Spring4MVCProject.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.springmvc.Spring4MVCProject.Exception.SpringMVC4Exception;
import com.test.springmvc.Spring4MVCProject.Iservice.ISpringMVC4Service;
import com.test.springmvc.Spring4MVCProject.Model.Employee;

@Controller
public class SpringMVC4Controller {
	
	@Autowired
	ISpringMVC4Service iSpringMVC4Service;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcomeForWebProject(ModelMap model){
		//model.addAttribute("employee", new Employee());
		System.out.println("Home");
		return new ModelAndView("home", "employee", new Employee());
		//return "home";
	}
	
	@RequestMapping(value = "/showData", method = RequestMethod.GET)
	public String showData(@RequestParam("salary") String salVal, ModelMap model) throws Exception{
		iSpringMVC4Service.saySomthing();
		//int a =  10/0;
		model.addAttribute("mySalVal", salVal);
		return "showData";
	}
	
/*	@RequestMapping(value ="/insertEmp", method = RequestMethod.POST)
	public String insertEmployeeData(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("empId") String empId,
			@RequestParam("empAge") String empAge,
			@RequestParam("role") String role, ModelMap model) throws Exception {
		
		System.out.println("Inside insertData");
		String response = "";
		Employee employee = new Employee(firstName, lastName, Integer.parseInt(empId), Integer.parseInt(empAge), role);
		try {
		  response = iSpringMVC4Service.insertEmployee(employee);
		} catch (Exception e) {
			if (e instanceof DuplicateKeyException) {
				throw new SpringMVC4Exception("ERR-101", "A valid record already exits with the Employee Id");
			} else {
				throw new SpringMVC4Exception("ERR-102", "Something went wrong,please check the logs");
			}
		}
		System.out.println("Response from databse ::"+ response);
		model.addAttribute("message", response);
		return "success";
	}*/
	
	@RequestMapping(value ="/insertEmp", method = RequestMethod.POST)
	public String insertEmployeeData(@ModelAttribute("employee") @Valid Employee employee ,BindingResult bindingResult, ModelMap model) throws Exception {
		
		System.out.println("Inside insertData");
		String response = "";
		try {
			if(bindingResult.hasErrors()) {
				System.out.println("Employee data is null");
				return "home";
			}
		  response = iSpringMVC4Service.insertEmployee(employee);
		} catch (Exception e) {
			if (e instanceof DuplicateKeyException) {
				throw new SpringMVC4Exception("ERR-101", "A valid record already exits with the Employee Id");
			} else {
				throw new SpringMVC4Exception("ERR-102", "Something went wrong,please check the logs");
			}
		}
		System.out.println("Response from databse ::"+ response);
		model.addAttribute("message", response);
		return "success";
	}
	
	@RequestMapping(value ="/seachEmployee", method = RequestMethod.GET)
	public String searchEmployee(@RequestParam("empIdSearch") String empId,ModelMap model) throws Exception{
		String employeeName ;
		try {
			employeeName = iSpringMVC4Service.searchEmployee(Integer.parseInt(empId));
			if(employeeName == null) {
				model.addAttribute("message","Employee not found");
			}else {
				model.addAttribute("message","Employee found");
				model.addAttribute("name","Employee name is ::"+employeeName);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new SpringMVC4Exception("ERR-102", "Something went wrong,please check the logs");
			
		}
		return "success";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleSpringMVC4Excption(Exception e){
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorMessage", e);
		return model;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showDetails(ModelMap model) throws Exception {
		try {
			iSpringMVC4Service.saySomthing();
		} catch (Exception e) {
			throw new SpringMVC4Exception("Error-56", "Error mesaage for custom error");
		}
		return "showData";
	}
	
	@ExceptionHandler(SpringMVC4Exception.class)
	public ModelAndView handleSpringMVC4CustomExcption(SpringMVC4Exception exception){
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorMessage", exception.getErrorMessage());
		model.addObject("errorCode", exception.getErrorCode());
		return model;
	}

}
