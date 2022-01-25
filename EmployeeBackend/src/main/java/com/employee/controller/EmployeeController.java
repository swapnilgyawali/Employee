package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.Employee;
import com.employee.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees(){
		return service.getEmployees();
	}
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable int id){
		return service.getEmployee(id);
	}
	
	@GetMapping("/updateWorkDays/{id}/{days}")
	public String workDays(@PathVariable int id, @PathVariable int days) {
		return service.workDays(id, days);
	}
	
	@GetMapping("/updateVacationDays/{id}/{days}")
	public String vacationDays(@PathVariable int id, @PathVariable int days) {
		return service.vacationDays(id, days);
	}
	
}
