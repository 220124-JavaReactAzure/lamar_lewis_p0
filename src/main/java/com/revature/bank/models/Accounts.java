package com.revature.bank.models;

import java.io.Serializable;

public class Accounts implements Serializable {
	
	private String account_no;
	private double balance =0.0;
	private String client_id;
	private Client owner_id;
	
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Accounts(String account_no, double balance,String client_id) {
		super();
		this.account_no = account_no;
		this.balance = balance;
		this.client_id = client_id;
	}
	
	public Accounts(String client_id,double balance) {
		this.client_id = client_id;
		this.balance = balance;
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
		this.balance = Double.valueOf(balance);
	}



	public String getClient_id() {
		return client_id;
	}
	
	



	public String getOwner_id() {
		return client_id;
	}



	public void setOwner_id(Client owner_id) {
		this.owner_id = owner_id;
	}



	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}



	@Override
	public String toString() {
		return "Accounts [account_no=" + account_no + ", balance=" + balance + ", client_id=" + client_id + "]";
	}
		

}
