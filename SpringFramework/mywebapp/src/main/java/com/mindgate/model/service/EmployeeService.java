package com.mindgate.model.service;

import java.util.List;

import com.mindgate.exceptions.EmployeeNotFoundException;
import com.mindgate.model.beans.Employee;

public interface EmployeeService {
	// methods that calls the employee DAO methods
	// method that can store
	public int store(Employee employee);
	// method that can update name by id
	public Employee updateNameById(int id, String name)throws EmployeeNotFoundException;
	// method that can update salary by id
	public Employee updateSalaryById(int id, double salary)throws EmployeeNotFoundException;
	// method that can read Employee by id
	public Employee findById(int id)throws EmployeeNotFoundException;
	// method that can read all Employees
	public List<Employee> findEmployees();
	// method that can delete Employee by id
	public Employee deleteById(int id) throws EmployeeNotFoundException;
}
