package com.hibExample.test;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="employee")
public class Employee {
	@Id             //primary key
	@Column(name="emp_id")
	//@GeneratedValue 		//auto-increment
	private Long id;
	@Column(name="emp_first_name")
	private String first_name;
	@Column(name="emp_last_name")
	private String last_name;
	@Column(name="address")
	private String address;
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee(long id,String first_name,String last_name,String address){
		this.id=id;
		this.first_name=first_name;
		this.last_name=last_name;
		this.address=address;
		
	}
	
	public String toString(){
		return "EmployeeID is: "+id+" .Employee name is: "+first_name+" "+last_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

}
