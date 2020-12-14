package com.employeeportal.service;

import java.util.List;

import com.employeeportal.model.Employee;

public interface EmployeeService {
	
	Employee createEmployee (Employee employee);
	Employee updateEmployee (Employee employee);
	Employee getEmployee (long id);
	List<Employee> getAllEmployees ();
	void deleteEmployee (long id);
	

}
