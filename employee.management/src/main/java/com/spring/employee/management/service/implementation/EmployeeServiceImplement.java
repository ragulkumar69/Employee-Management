package com.spring.employee.management.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employee.management.model.Employee;
import com.spring.employee.management.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplement implements EmployeeService {

	@Autowired
	private EmployeeRepository Repo;
	
	@Override
	public List<Employee> getAllEmployee() {

		return Repo.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.Repo.save(employee);
	}

	@Override
	public Employee getEmployeeByID(long id) {
		Optional<Employee> optional = Repo.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("Employee Not Found "+id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.Repo.deleteById(id);
		
	}

}
