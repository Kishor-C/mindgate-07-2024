package com.mindgate.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.exceptions.EmployeeNotFoundException;
import com.mindgate.model.beans.Employee;
import com.mindgate.model.dao.EmployeeRepository;

@Service // spring container creates object 
public class EmployeeServiceImplV1 implements EmployeeService {

	@Autowired  // injects the object which implements EmployeeRepository
	private EmployeeRepository employeeDao;
	
	@Override
	public int store(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee updateNameById(int id, String name) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateSalaryById(int id, double salary) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findById(int id) throws EmployeeNotFoundException {
		Employee employee = employeeDao.findById(id);
		if(employee != null) {
			return employee;
		}
		throw new EmployeeNotFoundException("Employee with an id "+id+" not found");
	}

	@Override
	public List<Employee> findEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee deleteById(int id) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
