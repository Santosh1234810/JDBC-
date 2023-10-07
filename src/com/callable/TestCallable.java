package com.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestCallable {
	public static void main(String[] args) throws SQLException{
		
		Connection con = null;
		CallableStatement ctmt = null;
		
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdatabase", "root", "root");
			
			if (con == null)
			{
				System.out.println("Connection not established...");
			}
			else
			{
				System.out.println("Connection established...");
			}
			
			ctmt = con.prepareCall("{call insertData1 (?,?,?)}");
			ctmt.setInt(1, 114);
			ctmt.setString(2, "Sanjay");
			ctmt.setInt(3, 40000);
			
			ctmt.executeUpdate();
			System.out.println("Record inserted...");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}
}
