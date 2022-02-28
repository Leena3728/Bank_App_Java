package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateUsingPreparedStatement {

	public static void main(String[] args) throws SQLException {

		MySqlConnection ob = new MySqlConnection();
		Connection conn = ob.DBconnection();
		
		Scanner scan = new Scanner(System.in);
		
		 System.out.println("Enter the new student ID:");
		String sid = scan.nextLine();
		
		System.out.println("Enter the new student Name:");
		String sname = scan.nextLine();
		
		System.out.println("Enter the new student Address:");
		String saddres = scan.nextLine();
		
		PreparedStatement ps = conn.prepareStatement("update student set sname=?,saddres=? where sid=?");
		ps.setString(1, sname);
		ps.setString(2, saddres);
		ps.setString(3, sid);
		
		int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0)
		{
			System.out.println("Data Updated");
			
		}else
		{
			System.out.println("Data not Updated");
		}
		
		
		
		System.out.println("=======================================");
		
		System.out.println("Delete Operation");

		
		System.out.println("=======================================");

		System.out.println("Enter the student id to delete record ");

		String sid = scan.nextLine();
		
		PreparedStatement ps1 = conn.prepareStatement("delete from student where sid=?");
		ps1.setString(1, sid);
		
		
		int affectedRows = ps1.executeUpdate();
		if(affectedRows>0)
		{
			System.out.println("Data Deleted Sucessfully");
			
		}else
		{
			System.out.println("Data not deleted");
		}
		
		
		

		
		

		
		
		
		
		
	}

}
