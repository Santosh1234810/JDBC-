package com.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBatchProcessing {
	public static void main(String[] args) throws SQLException{
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdatabase","root","root");
		
		if (con == null)
		{
			System.out.println("Connection not established...");
		}
		else
		{
			System.out.println("Connection established...");
		}
		
		stmt = con.createStatement();
		
		stmt.addBatch("insert into customers values(113,'Shyam')");
		stmt.addBatch("insert into customers values(114,'Chetan')");
		
		stmt.executeBatch();
		
		System.out.println("Record inserted");
		
		
		String s1 = "select *from customers";
		rs = stmt.executeQuery(s1);
		
		while(rs.next())
		{
			System.out.println("Id: "+rs.getInt(1)+" "+"Name: "+rs.getString(2));
			
		}
		
	}
}
