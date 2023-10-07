package com.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStatement1 {
	
	Connection con = null;
	Statement stmt = null;
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
		String s1 = "create table employee2(id int primary key auto_increment, name varchar(30), salary int)";
		
		stmt = con.createStatement();
		stmt.executeUpdate(s1);
		
		System.out.println("Table created...");
	}
	
	public void insert() throws SQLException
	{
		String s2 = "insert into employee2(name,salary) values('Akshay',40000)";
		stmt = con.createStatement();
		stmt.executeUpdate(s2);
		
		System.out.println("Record inserted...");
	}
	
	public void delete() throws SQLException
	{
		String s3 = "delete from employee2 where id = 3";
		stmt = con.createStatement();
		stmt.executeUpdate(s3);
		
		System.out.println("Record deleted...");
	}
	
	public void update() throws SQLException
	{
		String s4 = "update employee2 set name='Sagar' where id = 1";
		stmt = con.createStatement();
		stmt.executeUpdate(s4);
		
		System.out.println("Record updated...");
	}
	public static void main(String[] args) throws SQLException {
		TestStatement1 ts1 = new TestStatement1();
		
		ts1.makeConnection();
//		ts1.create();
//		ts1.insert();
//		ts1.delete();
		ts1.update();
	}
}
