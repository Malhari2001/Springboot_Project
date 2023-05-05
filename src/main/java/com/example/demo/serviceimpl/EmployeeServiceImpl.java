package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.module.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;

@Service //it create object of this class in spring acts as @Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepo repo;
	@Override
	public Employee addEmployee(Employee e) {

		return repo.save(e);
	}
	@Override
	public Employee getEmployeeById(Integer eid) {

		return repo.findById(eid).orElseThrow(()-> new ResourceNotFoundException("Employee","id", eid));
	}
	@Override
	public List<Employee> getByDesignation(String designation) {

		return repo.findByDesignation(designation);
	}
	@Override
	public List<Employee> getBylessthanSal(Double sal) {

		return repo.emplessthansal(sal);
	}
	@Override
	public Employee updateEmployee(Employee e) {
		Employee e1=repo.findById(e.getEid()).orElse(null);
		if(e1!=null) {
			e1.setEname(e.getEname());
			e1.setDesignation(e.getDesignation());
			e1.setSal(e.getSal());
			e1.setPhno(e.getPhno());
			return repo.save(e1);
		}
		else {
			throw new ResourceNotFoundException("Employee", "Id", e.getEid());
		}

	}
	@Override
	public Employee deleteEmployee(Integer eid) {
		Employee e=repo.findById(eid).orElse(null);
		if(e!=null) {
			repo.delete(e);
			return e;
		}
		else {
			throw new ResourceNotFoundException("Employee","Id", eid);
		}
	}


}
