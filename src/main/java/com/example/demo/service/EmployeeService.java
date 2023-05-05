package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee e);
	
	Employee getEmployeeById(Integer eid);
	
	List<Employee >getByDesignation(String designation);
	
	List<Employee> getBylessthanSal(Double sal);
	
	Employee updateEmployee(Employee e);
	
	Employee deleteEmployee(Integer eid);
}
