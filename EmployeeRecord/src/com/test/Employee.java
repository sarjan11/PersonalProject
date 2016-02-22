package com.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="employee")
@RequestScoped
public class Employee {
	private int Id;
	private String firstName;
	private String lastName;
	private double salary;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	// just for debug purpose if required
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", salary=" + salary + "]";
	}

}
