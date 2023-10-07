package com.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStatement2 {
	Connection con = null;
	Statement stmt = null;
	
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
		String s1 = "create table person(id int primary key auto_increment, name varchar(30), city varchar(50))";
		stmt = con.createStatement();
		stmt.executeUpdate(s1);
		
		System.out.println("Table cretaed...");
	}
	
	public void insert() throws SQLException
	{
		String s2 = "insert into person(name, city) values('Ajay','Delhi')";
		stmt = con.createStatement();
		stmt.executeUpdate(s2);
		
		System.out.println("record inserted...");
	}
	
	public void update() throws SQLException
	{
		String s3 = "update person set city='Mumbai' where id=2";
		stmt = con.createStatement();
		stmt.executeUpdate(s3);
		
		System.out.println("Record updated...");
	}
	
	public void delete() throws SQLException
	{
		String s4 = "delete from person where id = 2";
		stmt = con.createStatement();
		stmt.executeUpdate(s4);
		
		System.out.println("Record deleted...");
	}
	public static void main(String[] args) throws SQLException {
		TestStatement2 ts2 = new TestStatement2();
		ts2.makeConnection();
		
//		ts2.create();
//		ts2.insert();
//		ts2.update();
		ts2.delete();
	}
}
