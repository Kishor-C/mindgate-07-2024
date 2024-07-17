package com.mindgate.model.dao;

import java.util.List;

import com.mindgate.model.beans.Employee;

public interface EmployeeRepository {
	// save method must store employee object and return an int
	public int save(Employee employee); 
	// findById method takes an id and returns an Employee object
	public Employee findById(int id);
	// findAll methods returns all the Employees in a collection
	public List<Employee> findAll();
	// deleteById method takes an id and deletes the employee 
	public void deleteById(int id);
	// update method takes id and updates the employee
	public Employee update(int id, Employee employee);
}
