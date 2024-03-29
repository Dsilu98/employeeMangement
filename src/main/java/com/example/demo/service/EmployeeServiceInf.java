package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Employee;

public interface EmployeeServiceInf {
	public void addEmployee(Employee e);
	public void addAllEmployee(List<Employee> e);
	public Employee getEmployeeById(Long id);
	public List<Employee> gettAllEmployee();
	public String updateEmployeeById(Long id, Employee e);
	public String deleteEmployeeById(Long id);
	public String deleteEmployee();
	
	//filter employee if their salary is greater than 
	public List<Employee> getEmployeeSalaryMorethan(Long sal);
	
	//filter employee if their salary is less than 
	public List<Employee> getEmployeeSalaryLessthan(Long sal);
	//Asc employee based their state
	public List<Employee> employeeAscState(Long sal);
	//Desc employee based their state
	public List<Employee> employeeDescState(Long sal);
	
	//Get employee in ascending order (name,state,salary,mobilenumber)
	public List<Employee> getEmployeeAsc();
	//Get employee in descding order (name,state,salary,mobilenumber)
	public List<Employee> getEmployeeDesc();
}
