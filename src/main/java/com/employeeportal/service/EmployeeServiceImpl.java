package com.employeeportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employeeportal.exception.ResourceNotFoundException;
import com.employeeportal.model.Employee;
import com.employeeportal.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		Optional<Employee> employeeDb = employeeRepository.findById(employee.getId());
		
		if (employeeDb.isPresent()) {
			Employee employeeUpdate = employeeDb.get();
			employeeUpdate.setId(employee.getId());
			employeeUpdate.setName(employee.getName());
			employeeUpdate.setRole(employee.getRole());
			employeeUpdate.setStartDt(employee.getStartDt());
			employeeRepository.save(employeeUpdate);
			return employeeUpdate;
		}
		else throw new ResourceNotFoundException("Employee " + employee.getId() + " does not exists.");
		
	}

	@Override
	public Employee getEmployee(long id) {
		
		Optional<Employee> employeeDb = employeeRepository.findById(id);
		if (employeeDb.isPresent()) {
			return employeeDb.get();
		}
		
		else throw new ResourceNotFoundException("Employee " + id + " does not exists.");
	}

	@Override
	public List<Employee> getAllEmployees() {
		Employee employee = new Employee();
		employeeRepository.save(employee);
		
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(long id) {
		
		Optional<Employee> employeeDb = employeeRepository.findById(id);
		if (employeeDb.isPresent()) {
			employeeRepository.delete(employeeDb.get());
		}
	}

}
