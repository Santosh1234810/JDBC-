package com.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestScrollableStatement {

	public static void main(String[] args) throws SQLException{
		Connection con = null;
		PreparedStatement ptmt = null;
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
		
		ptmt = con.prepareStatement("select *from employee1",ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY
				);
		
		rs = ptmt.executeQuery();
		
		rs.first();
		
		System.out.println("Id: "+rs.getInt("id")+" "+"Name: "+rs.getString("name"));
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		
		System.out.println("========================================================================");
		System.out.println("Reverse Data");
		
		rs.afterLast();
		
		while(rs.previous())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		
		
		
	}
}
