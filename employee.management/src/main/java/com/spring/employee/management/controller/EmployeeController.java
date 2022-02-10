package com.spring.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.employee.management.model.Employee;
import com.spring.employee.management.service.implementation.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService Service;
	
	@GetMapping("/")
	public String home(Model model){
		return "home.html";
	}
	
	//display list
	@GetMapping("/AdminHome")
	public String view(Model model) {
		model.addAttribute("listEmployees", Service.getAllEmployee());
		return "Admin.html";
	}
	

	
//	Add employee
	@GetMapping("/showNewEmployee")
	public String showNewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "Add.html";
	}
	
	@PostMapping("/saveEmployee")
//	handle form data modal attr
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
//		save emp to database
		Service.saveEmployee(employee);
		return "redirect:/AdminHome";
	}
	
	@GetMapping("/forUpdate/{id}")
//	to update
	public String forUpdate(@PathVariable(value = "id") long id, Model model) {
		
//		get employee
		Employee employee = Service.getEmployeeByID(id);
		
//		set employee
		model.addAttribute("employee", employee);
		
		return "Update.html";
	}
	
//	to delete
	@GetMapping("/forDelete/{id}")
	public String forDelete(@PathVariable (value ="id") long id) {
		this.Service.deleteEmployeeById(id);
		return "redirect:/AdminHome";
	}
	
	@GetMapping("/EmployeeProfileHome")
	public String Employeeview(Model model) {
		model.addAttribute("listEmployees", Service.getAllEmployee());
		return "Employee.html";
	}	
//	
	@GetMapping("/Employeelist")
	public String Profile(Model model) {
		Employee employeeProfile = new Employee();
		model.addAttribute("employeeProfile", employeeProfile);
		return "Employee.html";
	}
}


