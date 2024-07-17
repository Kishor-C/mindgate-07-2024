package com.mindgate.model.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.model.beans.Employee;
@Repository
public class EmployeeRepositoryJdbcImpl implements EmployeeRepository {
	
	@Autowired
	private JdbcTemplate template; // spring injects JdbcTemplate from its container

	@Override
	public int save(Employee employee) {
		int count = template.update("insert into employee(name,salary) values(?,?)", 
				employee.getName(), employee.getSalary());
		return count;
	}

	@Override
	public Employee findById(int id) {
		String query = "select * from employee where id = ?";
		
		//RowMapper takes care of converting result set to object, 
		// queryForObject & query methods pass rowNum & resultSet of that rowNum
		RowMapper<Employee> rowMapper = (result, rowNum) -> new Employee(
						result.getInt("id"),
						result.getString("name"),
						result.getDouble("salary")
						);
		//execute(query, rowMapper, ...args): returns the object
		Employee employee = null;
		try {
			employee = template.queryForObject(query, rowMapper, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		String query = "select * from employee";
		//RowMapper takes care of converting result set to object, 
		// queryForObject & query methods pass rowNum & resultSet of that rowNum
		RowMapper<Employee> rowMapper = (result, rowNum) -> new Employee(
						result.getInt("id"),
						result.getString("name"),
						result.getDouble("salary")
						);
		List<Employee> employees = template.query(query, rowMapper);
		return employees;
	}

	@Override
	public void deleteById(int id) {
		String query = "delete from employee where id = ?";
		template.update(query, id);
	}

	@Override
	public Employee update(int id, Employee employee) {
		String query = "update employee set name = ?, salary = ? where id = ?";
		template.update(query, employee.getName(), employee.getSalary(), id);
		return findById(id);
	}

}
