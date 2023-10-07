package com.statement;

import java.sql.*;
public class TestStatement {
	
	Connection con; 		
	Statement stmt;
	ResultSet rs = null;
	
	public Connection makeConnection() throws SQLException
	{	
			con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdatabase","root","root");
			
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
		String s = "create table employee1(id int primary key, name varchar(30), salary int)";
		
		Statement stmt = con.createStatement();
		stmt.executeUpdate(s);
		
		System.out.println("Table created");
	}
	
	public void insert() throws SQLException
	{
		String s1 = "insert into employee values(103,'Prasad',4500)";
		stmt = con.createStatement();
		stmt.executeUpdate(s1);
		
		System.out.println("Record inserted...");
	}
	
	public void update() throws SQLException
	{
		String s2 = "update employee set name='Suyog', where id = 103";
		stmt = con.createStatement();
		stmt.executeUpdate(s2);
	}
	
	public void delete() throws SQLException
	{
		String s3 = "delete from employee where id = 102";
		stmt = con.createStatement();
		stmt.executeUpdate(s3);
	}
	
	
	public static void main(String[] args) throws SQLException{
//		Connection con = null;
//		Statement stmt = null;
		
		
			
//			create employee
//			String s = "create table employee(id int primary key, name varchar(30), salary int)";
//			
//			stmt = con.createStatement();
//			stmt.executeUpdate(s);
//			
//			System.out.println("Table created");
			
//			String s1 = "insert into employee values(101,'Sanjay',50000)";
//			
//			stmt = con.createStatement();
//			stmt.executeUpdate(s1);
//			System.out.println("Data inserted");
			
//			Update
			/*
			String s2 = "update employee set salary=65000 where id = 101";
			
			stmt.executeUpdate(s2);
			System.out.println("Updated record");
			*/
			
//			delete the record
//			
//			String s3 = "delete from employee where id = 102";
//			
//			stmt = con.createStatement();
//			stmt.executeUpdate(s3);
//			System.out.println("Record deleted...");
//		
//		TestStatement ts = new TestStatement();
//		ts.makeConnection();
//		ts.create();
//		ts.insert();
//		ts.update();
//		ts.delete();
		
	}
}
