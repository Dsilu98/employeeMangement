package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.module.Employee;

@Service
public class EmployeeServiceInfImplement implements EmployeeServiceInf{
	@Autowired
	private EmployeeDao dao;
	
	@Override
	public void addEmployee(Employee e) {
		// TODO Auto-generated method stub
		dao.save(e);
	}

	@Override
	public void addAllEmployee(List<Employee> e) {
		// TODO Auto-generated method stub
		dao.saveAll(e);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> e = dao.findById(id);
		return e.orElse(null);
	}

	@Override
	public List<Employee> gettAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> empList = dao.findAll();
		return empList;
	}

	@Override
	public String updateEmployeeById(Long id, Employee e) {
		// TODO Auto-generated method stub
//		if(dao.existsById(id))
//			throw new EmptyResultD;
		return null;
	}

	@Override
	public String deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeSalaryMorethan(Long sal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeSalaryLessthan(Long sal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> employeeAscState(Long sal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> employeeDescState(Long sal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeAsc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeDesc() {
		// TODO Auto-generated method stub
		return null;
	}

}
