package com.mindgate.testing;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mindgate.model.beans.Employee;
import com.mindgate.model.dao.EmployeeRepository;

public class EmployeeOperationsTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int option = 0;
		// get the object from the container
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeRepository dao = 
				(EmployeeRepository)context.getBean("employeeRepositoryJdbcImpl");
		do { 
			// take the option and pass it to switch
			System.out.println("Enter 1: save 2: find by id "
					+ "3: find all 4: delete 5: update name 6: update salary 99: exit");
			option = scan.nextInt();
			switch(option) {
			case 1:
				Employee employee = new Employee();
				
				System.out.println("Enter Name:");
				employee.setName(scan.next());
				System.out.println("Enter Salary:");
				employee.setSalary(scan.nextDouble());
				int rows = dao.save(employee);
				System.out.println("Rows affected: "+rows);
				break;
			case 2: 
				System.out.println("Enter id to search");
				Employee emp = dao.findById(scan.nextInt());
				if(emp != null) {
					System.out.println("Id="+emp.getId()+", Name="+emp.getName());
				} else {
					System.err.println("Entered id is not found!");
				}
				break;
			case 3: 
				List<Employee> list = dao.findAll();
//				for(Employee e : list) {
//					System.out.println(e);
//				}
				list.forEach(e -> System.out.println(e));
				System.out.println("_____________________________________");
			}
			
				
		} while(option != 99);
		scan.close();
	}
}
