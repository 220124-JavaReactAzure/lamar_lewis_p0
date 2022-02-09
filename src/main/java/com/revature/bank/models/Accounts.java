package com.revature.bank.models;

import java.io.Serializable;

public class Accounts implements Serializable {
	
	private String account_no;
	private double balance;
	
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Accounts(String account_no, double balance) {
		super();
		this.account_no = account_no;
		this.balance = balance;
	}
	
	public Accounts(String account_no) {
		this.account_no = account_no;
	}



	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}



	@Override
	public String toString() {
		return "Accounts [account_no=" + account_no + ", balance=" + balance + "]";
	}
	
	
	
	
	
	

}
