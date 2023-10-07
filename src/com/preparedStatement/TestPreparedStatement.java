package com.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPreparedStatement {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		try
		{
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdatabase", "root", "root");
			
			if (con == null)
			{
				System.out.println("Connection not established...");
			}
			else
			{
				System.out.println("Connection establihsed...");
			}
			
//			Create table
//			String q = "create table students(id int primary key, name varchar(30), marks int)";
//			ptmt = con.prepareStatement(q);
//			ptmt.executeUpdate();
//			
//			System.out.println("Table created");
			
			/*Insert record
			String s = "insert into students values(?,?,?)";
			
			ptmt = con.prepareStatement(s);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter how many records you want:? ");
			int n = sc.nextInt();
			
			for (int i=1; i<=n; i++)
			{
				System.out.println("Enter id, name, marks");
				int id = sc.nextInt();
				String name = sc.next();
				int marks = sc.nextInt();
				ptmt.setInt(1, id);
				ptmt.setString(2, name);
				ptmt.setInt(3, marks);
				
			}
			
			System.out.println("Record inserted...");
			*/
			
			//Update record
			/*String q = "update students set name=? where id = ?";
			ptmt=con.prepareStatement(q);
			
			ptmt.setString(1, "Geeta");
			ptmt.setInt(2, 101);
			ptmt.executeUpdate();
			System.out.println("Record updated");
			*/
			
//			delete the record
			
			String q = "delete from students where id=?";
			
			ptmt = con.prepareStatement(q);
			ptmt.setInt(1, 104);
			
			ptmt.executeUpdate();
			
			System.out.println("Record deleted");
			
			ptmt = con.prepareStatement("select * from employee1");
			rs = ptmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1) +" "+rs.getString(2) +" "+rs.getInt(3));
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
