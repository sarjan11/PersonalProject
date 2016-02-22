package com.example.example;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="userBean")
@SessionScoped
public class userBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Author> result=new ArrayList<Author>();


	
	public List<Author> getResult() throws ClassNotFoundException{
	
		
		ResultSet rs=null;
		PreparedStatement ps=null;
		String query="select * from authors";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:cogentinfo", "scott", "Sarjan07");
			
			ps=con.prepareStatement(query);
			System.out.println("statement executed");
			
			ps.execute();
	         rs = ps.getResultSet();
			rs=ps.executeQuery();
			
			while(rs.next()){
				Author author=new Author();
				author.setAuthorId(rs.getInt(1));
				author.setAuthorName(rs.getString(2));
				System.out.println(author);
				result.add(author);
			}
		}
		catch(SQLException se){
			se.printStackTrace();
			System.out.println("Error occured");
		}
			
		
	return result;
	}
}
