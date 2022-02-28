package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bank.entities.BankUser;

public class BankEmployeeDBOperation {

	DBconnection ob = new DBconnection();
	Connection conn = ob.connection();
	
	

	public boolean login(long eid,String password) throws SQLException
	{
		
		PreparedStatement stmt=conn.prepareStatement("select * from bankemployee where bankEmpId=? and bankEmpPassword=? ");
		stmt.setLong(1,eid);
		stmt.setString(2,password);
		
		ResultSet result=stmt.executeQuery();
		if(result.next())
		{
			return true;
		}
		else

		{
		
		return false;
		
				
	}
}
	public boolean accountClose(long userId) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("delete from bankuser where userID=? ");
		stmt.setLong(1, userId);
		int affectedRows=stmt.executeUpdate();
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	public boolean openAccount(BankUser e) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("insert into bankuser values(?,?,?,?,?,?,?)");
		stmt.setLong(1, e.getUserId());
		stmt.setString(2,e.getUserName());
		stmt.setString(3,e.getUserAddress());
		stmt.setString(4,e.getUserPassword());
		stmt.setDouble(5, e.getBalance());
		stmt.setLong(6,e.getPhone());
		stmt.setString(7, e.getUserEmail());
		
		int affectedRows=stmt.executeUpdate();
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
		
		
	}
	public ResultSet checkUserinfo(long accId) 
	{
		ResultSet result=null;
		try
		{
		PreparedStatement stmt=conn.prepareStatement("select * from bankuser where userId=? ");
		stmt.setLong(1, accId);
		result=stmt.executeQuery();
		
	
		}
		catch(Exception e)
		{
			System.out.println("Wrong User Id..!!");
		}
		return result;
	}

	public boolean changePassword(long eid,String newPassword) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("update bankemployee set bankEmpPassword=? where bankEmpId=? ");
		stmt.setString(1,newPassword);
		stmt.setLong(2, eid);
		int affectedRows=stmt.executeUpdate();
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	public void logout() throws SQLException {
		conn.close();

	}
}