package com.employee.dto;

public class Employee {
	public Employee() {}
	
	public Employee(int id, String name, String type, int workingDays, int vacations) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.workingDays = workingDays;
		this.vacations = vacations;
	}

	private int id;
	private String name;
	private String type;
	private int workingDays;
	private int vacations;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}
	public int getVacations() {
		return vacations;
	}
	public void setVacations(int vacations) {
		this.vacations = vacations;
	}
	
}
