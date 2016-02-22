package com.hibExample.test;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
//@Table(name="HibEmp")
public class TestHib {
	@Id             //primary key
	@Column(name="emp_id")
	//@GeneratedValue 		//auto-increment
	private Long id;
	@Column(name="emp_name")
	private String name;
	
	public TestHib(long id,String name){
		this.id=id;
		this.name=name;
		
	}
	
	public String toString(){
		return "EmployeeID is: "+id+" .Employee name is: "+name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
