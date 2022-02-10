package com.spring.employee.management.service.implementation;

import java.util.List;

import com.spring.employee.management.model.Employee;

public interface EmployeeService {
	
//	get and show employee
	List<Employee> getAllEmployee();
	
//	to save method
	void saveEmployee(Employee employee);
	
//	get employee by id for update
	Employee getEmployeeByID(long id);
	
//	for delete
	void deleteEmployeeById(long id);
}
