package com.callable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestResultSet {
	public static void main(String[] args)  throws SQLException{
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
		
		String s1 = "select *from employee1";
		rs = stmt.executeQuery(s1);
		
		while (rs.next())
		{
			System.out.println(rs.getInt(1) +" "+rs.getString(2) +" "+rs.getInt(3));
		}
	}
}
