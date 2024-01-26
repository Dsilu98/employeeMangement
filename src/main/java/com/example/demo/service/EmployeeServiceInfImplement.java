package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.exception.EmployeeNotFoundException;
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
		return e.orElseThrow(()->new EmployeeNotFoundException("Employee having id: "+id+" not present"));
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> empList = dao.findAll();
		if(empList.isEmpty())
			throw new EmployeeNotFoundException("There is not employee data present in this database");
		return empList;
	}

	@Override
	public boolean  updateEmployeeById(Long id, Employee e) {
		// TODO Auto-generated method stub
		boolean result=true;
		if(!dao.existsById(id)) {
			result = false;
			throw new EmployeeNotFoundException("Employee with id : "+id+" is not present");
		}
		Employee savedEmployee = getEmployeeById(id);
		Long temp = savedEmployee.getId();
		savedEmployee = e;
		savedEmployee.setId(e.getId());
		return result;
	}

	@Override
	public boolean deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		boolean result=true;
		if(!dao.existsById(id)) {
			result = false;
			throw new EmployeeNotFoundException("Employee with id : "+id+" is not present");
		}
		dao.deleteById(id);
		return result;
	}

	@Override
	public boolean deleteEmployee() {
		// TODO Auto-generated method stub
		boolean result=true;
		if(dao.count()==0) {
			result = false;
			throw new EmployeeNotFoundException("There is no data present in this ");
		}
		return result;
	}

	@Override
	public List<Employee> getEmployeeSalaryMorethan(Long sal) {
		// TODO Auto-generated method stub
		if(dao.count()==0) {
			throw new EmployeeNotFoundException("There is no data present in this ");
		}
		List<Employee> empList = getAllEmployee();
		List<Employee> resultList= new ArrayList<>();
		for(int i=0;i<empList.size();i++) {
			Employee e = empList.get(i);
			if(e.getSalary()>sal)
				resultList.add(e);
		}
		return resultList;
	}

	@Override
	public List<Employee> getEmployeeSalaryLessthan(Long sal) {
		// TODO Auto-generated method stub
		if(dao.count()==0) {
			throw new EmployeeNotFoundException("There is no data present in this ");
		}
		List<Employee> empList = getAllEmployee();
		List<Employee> resultList= new ArrayList<>();
		for(int i=0;i<empList.size();i++) {
			Employee e = empList.get(i);
			if(e.getSalary()<sal)
				resultList.add(e);
		}
		return resultList;
	}

	@Override
	public List<Employee> employeeAscState() {
		// TODO Auto-generated method stub
		if(dao.count()==0) {
			throw new EmployeeNotFoundException("There is no data present in this ");
		}
		List<Employee> empList = getAllEmployee();
		Collections.sort(empList, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getAddress().getState().compareTo(e2.getAddress().getState());
			}
		});
		return empList;
	}

	@Override
	public List<Employee> employeeDescState() {
		// TODO Auto-generated method stub
		if(dao.count()==0) {
			throw new EmployeeNotFoundException("There is no data present in this ");
		}
		List<Employee> empList = getAllEmployee();
		Collections.sort(empList, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return -e1.getAddress().getState().compareTo(e2.getAddress().getState());
			}
		});
		return empList;

	}

	@Override
	public List<Employee> getEmployeeAsc() {
		// TODO Auto-generated method stub
		if(dao.count()==0) {
			throw new EmployeeNotFoundException("There is no data present in this ");
		}
		List<Employee> empList = getAllEmployee();
		Collections.sort(empList, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				int firstNameCompare = e1.getFirstName().compareToIgnoreCase(e2.getFirstName());
				if(firstNameCompare!=0)
					return firstNameCompare;
				int stateCompare = e1.getAddress().getState().compareToIgnoreCase(e2.getAddress().getState());
				if(stateCompare!=0)
					return stateCompare;
				int salryCompare = Long.compare(e1.getSalary(),e2.getSalary());
				if(salryCompare!=0)
					return salryCompare;
				int designationCompare = e1.getDesignation().compareToIgnoreCase(e2.getDesignation());
				if(designationCompare!=0)
					return designationCompare;
				return e1.getMobile().compareTo(e2.getMobile());
			}
		});
		return empList;

	}

	@Override
	public List<Employee> getEmployeeDesc() {
		// TODO Auto-generated method stub
		if(dao.count()==0) {
			throw new EmployeeNotFoundException("There is no data present in this ");
		}
		List<Employee> empList = getAllEmployee();
		Collections.sort(empList, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				int firstNameCompare = e1.getFirstName().compareToIgnoreCase(e2.getFirstName());
				if(firstNameCompare!=0)
					return -firstNameCompare;
				int stateCompare = e1.getAddress().getState().compareToIgnoreCase(e2.getAddress().getState());
				if(stateCompare!=0)
					return -stateCompare;
				int salryCompare = Long.compare(e1.getSalary(),e2.getSalary());
				if(salryCompare!=0)
					return -salryCompare;
				int designationCompare = e1.getDesignation().compareToIgnoreCase(e2.getDesignation());
				if(designationCompare!=0)
					return -designationCompare;
				return -e1.getMobile().compareTo(e2.getMobile());
			}
		});
		return empList;
	}

	

}
