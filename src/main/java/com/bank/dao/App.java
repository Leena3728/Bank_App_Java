package com.bank.dao;

import java.sql.ResultSet;
import java.util.Scanner;

import com.bank.entities.BankUser;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("==========================================================================================================");
    	System.out.println("                                             Welcome to ABC Bank                                          ");
    	System.out.println("==========================================================================================================");
    	
    	boolean status=true;
    	do
    	{
       try
       {
    	Scanner scan=new Scanner(System.in);
    	System.out.println("\t Press 1 -> Bank Employee ");
    	System.out.println("\t Press 2 -> Bank User ");
    	int userType=scan.nextInt();
    	
    	BankEmployeeDBOperation bo=new BankEmployeeDBOperation();
    	
    	if(userType==1)
    	{
    		System.out.println("\t Enter Employee Id:");
    		long eId=scan.nextLong();
    		System.out.println("\t Enter Password:");
    		String password=scan.next();
    		boolean validUser=bo.login(eId, password);
    		
    		if(validUser)
    		{
    	       	System.out.println("==========================================================================================================");
    			System.out.println("Login Successfull!!");
    	       	System.out.println("==========================================================================================================");
    	       	System.out.println("\t 1.Open Account\r\n"
    	       			+ "2.Close Account\r\n"
    	       			+ "3.Check User Information\r\n"
    	       			+ "4.Password Change\r\n"
    	       			+ "5.Logout");
    	       	int operation=scan.nextInt();
    	       	if(operation==1)
    	       	{
    	       		System.out.println("==========================================================================================================");
	       			System.out.println("Account Opening");
	       			System.out.println("==========================================================================================================");
	       		
    	       		System.out.println("Enter account Id for the user:");
    	       		long accId=scan.nextLong();
    	       		System.out.println("Enter account holder name: :");
    	       		String accName=scan.next();
    	       		System.out.println("Enter account holder address: :");
    	       		String accAddress=scan.next();
    	       		System.out.println("Set account holder password: :");
    	       		String accPassword=scan.next();
    	       		System.out.println("Enter initial balance:");
    	       		double accBalance=scan.nextDouble();
    	       		System.out.println("Enter Phone Number:");
    	       		long accPhone=scan.nextLong();
    	       		System.out.println("Enter email address: :");
    	       		String accEmail=scan.next();
    	       		
    	       		BankUser u=new BankUser(accId, accName, accAddress, accBalance,accPassword, accPhone,
    	       				accEmail);
    	       		if(bo.openAccount(u))
    	       		{
    	       			System.out.println("==========================================================================================================");
    	       			System.out.println("Account created!!");
    	       			System.out.println("==========================================================================================================");
    	       		}
    	       		else
    	       		{
    	       			System.out.println("Problem in account creation!! ");
    	       		}
    	       		
    	       	}
    	       	else if(operation==2)
    	       	{
    	       		System.out.println("Enter account id for closing account:");
    	       		long accId=scan.nextLong();
    	       		
    	       		if(bo.accountClose(accId))
    	       		{
    	       			System.out.println("Account closed successfully!! ");
    	       		}
    	       		else
    	       		{
    	       			System.out.println("Problem in account closing!! ");
    	       		}
    	       	}
    	       	else if(operation==3)
    	       	{
    	       		System.out.println("==========================================================================================================");
        			System.out.println("User Infomation ");
        	       	System.out.println("==========================================================================================================");
        	       	System.out.println("Enter the account Id for the User:");
        	       	long accId=scan.nextLong();
        	       	ResultSet result=bo.checkUserinfo(accId);
        	       	if(result!=null)
        	       	{
        	       		while(result.next())
        	       		{
        	       		System.out.println("User Name:"+result.getString(2));
        	       		System.out.println("Address:"+result.getString(3));
        	       		System.out.println("Phone number:"+result.getLong(6));
        	       		System.out.println("Email:"+result.getString(7));        	     
        	       		System.out.println("Balance:"+result.getDouble(5));
        	       	}
        	       	}
        	       	else
        	       	{
        	       		System.out.println("Account Id does not exist!! ");
        	       	}
    	       	}
    	       	else if(operation==4)
    	       	{
    	       		System.out.println("Enter your Employee Id:");
    	       		long eid=scan.nextLong();
    	       		System.out.println("Set new Password:");
    	       		String newPassword=scan.next();
    	       		if(bo.changePassword(eid, newPassword))
    	       		{
    	       			System.out.println("Password Changed!!");
    	       		}
    	       		else
    	       		{
    	       			System.out.println("Error occurred!!");
    	       		}
    	       	}
    	       	else if(operation==5)
    	       	{
    	       		bo.logout();
    	       		System.out.println("==========================================================================================================");
        			System.out.println("Logged Out!! ");
        	       	System.out.println("==========================================================================================================");

    	       	}
    	       	
    	       	
    		}
    		else
    		{
    	       	System.out.println("==========================================================================================================");
    			System.out.println("Incorrect UserId/Password!! ");
    	       	System.out.println("==========================================================================================================");

    		}
    		
    		
    	}
    	
    	else if(userType==2)
    	{
    		BankUserDBOperation ob=new BankUserDBOperation();
    		System.out.println("\t Enter Account Id:");
    		long uId=scan.nextLong();
    		System.out.println("\t Enter Password:");
    		String password=scan.next();
    		
    		if(ob.login(uId, password))
    		{
    	       	System.out.println("==========================================================================================================");
    			System.out.println("Logged In!!");
    	       	System.out.println("==========================================================================================================");
    	       	
    	       	
    	       	System.out.println("\r\n"
    	       			+ "1.Withdraw\r\n"
    	       			+ "2.Deposit\r\n"
    	       			+ "3.Check Balance\r\n"
    	       			+ "4.Fund Transfer\r\n"
    	       			+ "5.Change Password\r\n"
    	       			+ "6.Recent Transaction\r\n"
    	       			+ "7.Logout");
    	     
    	       	int operation=scan.nextInt();
    	       	
    	       	if(operation==1)
    	       	{
    	       		System.out.println("Enter the withdrawal amount:");
    	       		double withdrawAmount=scan.nextDouble();
	       			System.out.println("==========================================================================================================");
    	       		ob.withdraw(withdrawAmount, uId);
	       			System.out.println("==========================================================================================================");

    	       	}
    	       	else if(operation==2) //Deposit 
    	       	{
    	       		System.out.println("Enter the deposit amount:");
    	       		double depositAmount=scan.nextDouble();
	       			System.out.println("==========================================================================================================");
    	       		ob.deposit(depositAmount, uId);
	       			System.out.println("==========================================================================================================");

    	       	}
    	       	else if(operation==3)
    	       	{
    	       		ResultSet rs = ob.balanceCheck(uId);
    	       		while(rs.next()) {
    	       			System.out.println("Available Balance:"+rs.getDouble(5));
    	       		}
	       			System.out.println("==========================================================================================================");
    	       		
    	       	}
    	    	else if(operation==4)
    	       	{
    	    		System.out.println("Enter the Check Balance:");
    	       		double fundTransfer=scan.nextDouble();
	       			System.out.println("==========================================================================================================");
    	       		ob.deposit(fundTransfer, uId);
	       			System.out.println("==========================================================================================================");

    	       	}
    	    	else if(operation==5)
    	       	{
    	    		System.out.println("Enter new password:");
    	    		String newPassword=scan.next();
    	       		if(ob.changePassword(uId, newPassword))
    	       		{
    	       			System.out.println("==========================================================================================================");
    	    			System.out.println("Password changed successfully!!");
    	    	       	System.out.println("==========================================================================================================");

    	       		}
    	       		else
    	       		{
    	       			System.out.println("==========================================================================================================");
    	    			System.out.println("Problem in password change!!");
    	    	       	System.out.println("==========================================================================================================");

    	       		}
    	       	}
    	    	
    	    	else if(operation==6)
    	       	{
    	       		System.out.println("==========================================================================================================");
	       			System.out.println("Transaction Id" + "\t" +"Amount"+ "\t"+"Date"+"\t\t"+"Sender Id"+"\t"+"Receiver Id");
    	       		System.out.println("==========================================================================================================");

    	       		ResultSet rs=ob.transactions(uId);
    	       		while(rs.next())
    	       		{
    	       			System.out.println(rs.getLong(1) + "\t\t" +rs.getDouble(2)+ "\t"+rs.getTimestamp(3)+"\t"+rs.getLong(4)+"\t"+rs.getLong(5));
    	       		}
    	       		System.out.println("==========================================================================================================");    	    	
    	    	
    	    	
    	    	
    	       	}
    	    	
    	    	
    	    	else if(operation==7)
    	       	{
    	       		ob.logout();
    	       		status=false;
    	       		System.out.println("==========================================================================================================");
        			System.out.println("Logged Out!!");
        	       	System.out.println("==========================================================================================================");

    	       	}
    	    	else 
    	       	{
    	    		System.out.println("==========================================================================================================");
        			System.out.println("Wrong Input!!");
        	       	System.out.println("==========================================================================================================");

    	       	}
    	       	
    	       	
    		}
    		else
    		{
    			System.out.println("==========================================================================================================");
    			System.out.println("User Id or Password Incorrect!!");
    	       	System.out.println("==========================================================================================================");

    		}
    		
    	}
    	else
    	{
    		System.out.println("\t Please enter a correct input!!");
    	}
       }
       catch(Exception e)
       
       {
    	   System.out.println(e.getMessage());
    	   System.out.println("\t Wrong Input!!");
    	   System.out.println("\t Provide Number input!!");
       	   System.out.println("==========================================================================================================");

       }
    	}
    	while(status);
    }
}