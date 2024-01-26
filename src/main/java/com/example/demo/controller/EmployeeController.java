package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Employee;
import com.example.demo.service.EmployeeServiceInfImplement;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeServiceInfImplement controller;
	
	@PostMapping("/employee")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee e){
		controller.addEmployee(e);
		String s = "Employee with id: "+e.getId()+" created";
		return new ResponseEntity<String>(s,HttpStatus.CREATED);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<List<String>> addEmployees(@Valid @RequestBody List<Employee> empList) {
		//TODO: process POST request
		controller.addAllEmployee(empList);
		List<String> result = new ArrayList<>();
		for(Employee emp: empList) {
			String s = "Employee with id : "+emp.getId() +" has created";
			result.add(s);
		}
		return new ResponseEntity<List<String>>(result,HttpStatus.CREATED);
	}
	
	@GetMapping("/employee{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee e = controller.getEmployeeById(id);
		return new ResponseEntity<Employee>(e,HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> empList = controller.getAllEmployee();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.FOUND);
	}
	
	@PutMapping("/employee{id}")
	public ResponseEntity<String> updateEmployee(@Valid @PathVariable @RequestBody Long id,Employee e){
		controller.updateEmployeeById(id, e);
		return new ResponseEntity<String>("Employee with id: "+e.getId()+" has been updated",HttpStatus.OK);
	}
	
	@GetMapping("/employeeSalmore{sal}")
	public ResponseEntity<List<Employee>> getEmpSalMoreThan(@PathVariable Long sal){
		List<Employee> empList = controller.getEmployeeSalaryMorethan(sal);
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.FOUND);
	}
	
	@GetMapping("/employeeSalless{sal}")
	public ResponseEntity<List<Employee>> getEmpSalLessThan(@PathVariable Long sal){
		List<Employee> empList = controller.getEmployeeSalaryLessthan(sal);
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.FOUND);
	}
	
	@GetMapping("/employeeAscState")
	public ResponseEntity<List<Employee>> getEmpaAscByState(){
		List<Employee> empList = controller.employeeAscState();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.FOUND);
	}
	
	@GetMapping("/employeeDescState")
	public ResponseEntity<List<Employee>> getEmpaDescByState(){
		List<Employee> empList = controller.employeeDescState();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.FOUND);
	}
	
	@GetMapping("/empAsc")
	public ResponseEntity<List<Employee>> getEmpByAsc(){
		List<Employee> empList = controller.getEmployeeAsc();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.FOUND);
	}
	
	@GetMapping("/empDsc")
	public ResponseEntity<List<Employee>> getEmpByDsc(){
		List<Employee> empList = controller.getEmployeeDesc();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.FOUND);
	}
}
