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
		int count = template.update("insert into employee values(?,?,?)", 
				employee.getId(), employee.getName(), employee.getSalary());
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
		Employee employee = template.queryForObject(query, rowMapper, id);
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee update(int id, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
