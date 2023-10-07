package com.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPreparedStatement2 {
	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	
	public Connection makeConnection() throws SQLException
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
		
		return con;
	}
	
	public void create() throws SQLException
	{
		String s1 = "create table students2(id int primary key, name varchar(30), marks int)";
		ptmt = con.prepareStatement(s1);
		ptmt.executeUpdate();
		
		System.out.println("Table created...");
	}
	
	public void insert() throws SQLException
	{
		String s2 = "insert into students2 values(?,?,?)";
		ptmt = con.prepareStatement(s2);
//		ptmt.executeUpdate();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many records you want?: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++)
		{
			System.out.println("Enter the id: ");
			int id = sc.nextInt();
			
			System.out.println("Enter the name: ");
			String name = sc.next();
			
			System.out.println("Enter the marks: ");
			int marks = sc.nextInt();
			
			ptmt.setInt(1, id);
			ptmt.setString(2,name);
			ptmt.setInt(3, marks);
		}
		
		System.out.println("Record inserted...");
	}
	
	public void update() throws SQLException
	{
		String s3 = "update students2 set name = 'Sagar' where id = ?";
		ptmt = con.prepareStatement(s3);
		
		System.out.println("Record updated...");
		
	}
	public static void main(String[] args) throws SQLException{
		TestPreparedStatement2 ts1 = new TestPreparedStatement2();
		
		ts1.makeConnection();
		
//		ts1.create();
		ts1.insert();
//		ts1.update();
	}
}
