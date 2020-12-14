package com.employeeportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeportal.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
