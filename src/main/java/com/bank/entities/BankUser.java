package com.bank.entities;

public class BankUser {
	long userId;
	String userName;
	String UserAddress;
	double balance;
	String userPassword;
	long phone;
	String userEmail;
	
	
	public BankUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BankUser(long userId, String userName, String userAddress, double balance, String userPassword, long phone,
			String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		UserAddress = userAddress;
		this.balance = balance;
		this.userPassword = userPassword;
		this.phone = phone;
		this.userEmail = userEmail;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return UserAddress;
	}
	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	

}
