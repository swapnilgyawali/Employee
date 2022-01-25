package com.employee.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee.dto.Employee;
import com.employee.service.EmployeeService;

@Service 
public class EmployeeServiceImpl implements EmployeeService {
	static Map<Integer,Employee> employees = new HashMap<>();
	static {
		Employee e1 = new Employee(1, "a", "Hourly", 260, 10);
		Employee e2 = new Employee(2, "b", "Salaried", 260, 15);
		Employee e3 = new Employee(3, "c", "Managers", 260, 30);
		Employee e4 = new Employee(4, "a", "Hourly", 52, 2);
		Employee e5 = new Employee(5, "b", "Salaried", 70, 4);
		Employee e6 = new Employee(6, "c", "Managers", 26, 2);
		employees.put(1,e1);
		employees.put(2,e2);
		employees.put(3,e3);
		employees.put(4,e4);
		employees.put(5,e5);
		employees.put(6,e6);
	}
	public List<Employee> getEmployees(){
		List<Employee> emp = new ArrayList<Employee>();
		for(Map.Entry<Integer, Employee> e: employees.entrySet()) {
			emp.add(e.getValue());
		}
		return emp;
	}
	@Override
	public String workDays(int id, int workingDays) {
		if(workingDays > 260 || workingDays <= -1) {
			return "Invalid range of values";
		}
		Employee e = getEmployee(id);
		if(e.getType().equals("Hourly")) {
			e.setVacations(workingDays/26);
		}else if(e.getType().equals("Salaried")) {
			e.setVacations(workingDays/17);
		}else if(e.getType().equals("Managers")) {
			e.setVacations(workingDays/11);
		}
		e.setWorkingDays(workingDays);
		employees.put(id, e);
		return "Updated Work & Vacation day details";
	}
	@Override
	public String vacationDays(int id, int vacationDays) {
		Employee e = getEmployee(id);
		if(e.getVacations() < vacationDays) {
			return "Vacation days are less. please enter different value";
		}
		e.setVacations(e.getVacations()-vacationDays);
		employees.put(id, e);
		return "Updated Vacation day details";
	}
	@Override
	public Employee getEmployee(int id) {
		List<Employee> empl = getEmployees();	
		Optional<Employee> emp = empl.stream().filter(e->e.getId()==id).findFirst();
		if(emp.isPresent()) {
			return emp.get();
		}
		return new Employee();
	}
}
