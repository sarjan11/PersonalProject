package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;



@ManagedBean(name="empBean")
@SessionScoped
public class empBean {
	@ManagedProperty(value = "#{employee}")
	Employee emp=new Employee();
	List<Employee> records=new ArrayList<Employee>();
	ResultSet rs=null;
	PreparedStatement ps=null;
	
	public List<Employee> getRecords() throws ClassNotFoundException{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:cogentinfo", "scott", "Sarjan07");
			String query="select * from employee";
			ps=con.prepareStatement(query);
			ps.execute();
			rs=ps.getResultSet();
			while(rs.next()){
				emp.setId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setSalary(rs.getDouble(4));
				records.add(emp);
			}
			
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		
		return records;
	}
	
	public void addRecords(int id,String firstName,String lastName, double sal) throws ClassNotFoundException{
		Employee emp=new Employee();
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:cogentinfo", "scott", "Sarjan07");
		String query="insert into employee values(?,?,?,?)";
		ps=con.prepareStatement(query);
		ps.setInt(1, emp.getId());
		ps.setString(2, emp.getFirstName());
		ps.setString(3, emp.getLastName());
		ps.setDouble(4, emp.getSalary());
		ps.executeUpdate();
		con.commit();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
	}
}
