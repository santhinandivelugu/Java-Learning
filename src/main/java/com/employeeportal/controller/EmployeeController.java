package com.employeeportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeportal.model.Employee;
import com.employeeportal.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employeeportal")
public class EmployeeController {
	
	@Autowired EmployeeServiceImpl employeeService;
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok().body(employeeService.createEmployee(employee));
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		employee.setId(id);
		return ResponseEntity.ok().body(employeeService.updateEmployee(employee));		
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
		return ResponseEntity.ok().body(employeeService.getEmployee(id));
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok().body(employeeService.getAllEmployees());
	}

	@DeleteMapping("/employees/{id}")
	public HttpStatus deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
		return HttpStatus.OK;
	}

}
