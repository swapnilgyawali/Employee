package com.employee.service;

import java.util.List;

import com.employee.dto.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();

	String workDays(int id, int workingDays);
	
	String vacationDays(int id, int workingDays);

	Employee getEmployee(int id);
	
}
