package com.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPreparesStatementUsingMethod {
	
	static Connection con = null;
	static PreparedStatement ptmt = null;
	
	public static Connection makeConnection()
	{
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
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return con;
	}
	
	public static void createTable() throws SQLException
	{
		con = makeConnection();
		
//		Create table
		String q = "create table students1(id int primary key, name varchar(30), marks int)";
		ptmt = con.prepareStatement(q);
		ptmt.executeUpdate();
		
		System.out.println("Table created");
	}
	public static void insert() throws SQLException
	{
		con = makeConnection();
		
		String s = "insert into students1 values(?,?,?)";
		
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
		
	}
	
	public static void update() throws SQLException
	{
		con = makeConnection();
		//Update record
		String q = "update students1 set name=? where id = ?";
		ptmt=con.prepareStatement(q);
		
		ptmt.setString(1, "Geeta");
		ptmt.setInt(2, 101);
		ptmt.executeUpdate();
		System.out.println("Record updated");
		
	}
	
	public static void delete() throws SQLException
	{
		String q = "delete from students1 where id=?";
		
		ptmt = con.prepareStatement(q);
		ptmt.setInt(1, 104);
		
		ptmt.executeUpdate();
		
		System.out.println("Record deleted");
	}
	
	public static void main(String[] args) throws SQLException{
		String ch;
		do
		{
			System.out.println("1. Create table ");
			System.out.println("2. Insert Record ");
			System.out.println("3. Update Record ");
			System.out.println("4. Delete Record ");
			System.out.println("5. Exit ");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the choice: ");
			int choice = sc.nextInt();
			
			switch(choice)
			{
			
			case 1:
				createTable();
				break;
				
			case 2:
				insert();
				break;
				
			case 3:
				update();
				break;
				
			case 4:
				delete();
				break;
				
			case 5:
				System.exit(0);
				
				default:
					System.out.println("Wrong choice");
			}
			
			System.out.println("Do you want to continue yes or no :? ");
			ch = sc.next();
			
		}
		while(ch.equals(ch)); 
	}
	
	
}
