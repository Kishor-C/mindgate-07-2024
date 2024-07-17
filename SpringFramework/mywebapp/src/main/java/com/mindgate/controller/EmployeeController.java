package com.mindgate.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindgate.exceptions.EmployeeNotFoundException;
import com.mindgate.model.beans.Employee;
import com.mindgate.model.service.EmployeeService;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {
	
	@Autowired // injects the object that implements EmployeeService
	private EmployeeService employeeService;
	
	// http://localhost:9090/mywebapp/spring/employee/greet
	
	@RequestMapping(path="/findEmployee", method = RequestMethod.POST)
	public ModelAndView findEmployee(@RequestParam("empId") int id) {
		try { 
			Employee employee = employeeService.findById(id);
			return new ModelAndView("home", "emp", employee);
		} catch(EmployeeNotFoundException ex) {
			return new ModelAndView("timer", "err", ex.getMessage());
		}
	}
	
	@RequestMapping(path="/time")
	public ModelAndView timer() {
		// code to call service will be there, then ModelAndView is returned
		ModelAndView modelView = new ModelAndView("timer", "timeKey", LocalDateTime.now());
		return modelView;
	}
	
	@RequestMapping(path="/greet") // by default HTTP method is GET
	public String greetings() {
		/*
		 *  returns the view name
		 *  Front-Controller adds /WEB-INF/pages/viewname.jsp
		 *  i.e., /WEB-INF/pages/home.jsp
		 */
		return "home"; 
	}
}
