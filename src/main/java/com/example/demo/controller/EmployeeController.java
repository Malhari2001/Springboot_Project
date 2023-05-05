package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.module.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired	
	EmployeeService ser; //For achieving abstraction we taking rference of interface 
    @PostMapping("/addEmployee")
	ResponseEntity<Employee> addEmployee(@RequestBody Employee e){
		return new ResponseEntity<Employee>(ser.addEmployee(e),HttpStatus.CREATED);
	}                                       //here caling method
     
    //it will return Employee
    @GetMapping("/getById")
    ResponseEntity<Employee> getEmployeebyId(@RequestHeader Integer eid){
    	return new ResponseEntity<Employee>(ser.getEmployeeById(eid),HttpStatus.FOUND);
    }
    //localhost:8080/getByDes
    @GetMapping("/getByDes")
    ResponseEntity<List<Employee>> getEmployeebyDes(@RequestHeader String designation){
    	return new ResponseEntity<List<Employee>>(ser.getByDesignation(designation),HttpStatus.FOUND);
    }
  //localhost:8080/getBySal
    @GetMapping("/getBySal")
    ResponseEntity<List<Employee>> getEmployeebySal(@RequestHeader Double sal){
    	
    	return new ResponseEntity<List<Employee>>(ser.getBylessthanSal(sal),HttpStatus.FOUND);
    }
    @PutMapping("/updateEmp")
    ResponseEntity<Employee> updateEmployeebyId(@RequestBody Employee user){
    	
    	return new ResponseEntity<Employee>(ser.updateEmployee(user),HttpStatus.OK);
}
    @DeleteMapping("/deleteEmp")
    ResponseEntity<Employee> deleteEmployeebyId(@RequestParam Integer eid){
    	
    	return new ResponseEntity<Employee>(ser.deleteEmployee(eid),HttpStatus.OK);
}
}