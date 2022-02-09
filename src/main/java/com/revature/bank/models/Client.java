package com.revature.bank.models;

import java.io.Serializable;

public class Client implements Serializable {
	
	private String user_id;
	private String fName;
	private String lName;
	private String email;
	private String password;
	private String userName;
	
	// default constructor
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}	
	

	public Client(String user_id, String fName, String lName, String email, String password, String userName) {
		super();
		this.user_id = user_id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.userName = userName;
	}


	//constructor
	public Client(String fName, String lName, String email, String password, String userName) {
		super();		
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.userName = userName;
	}



	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



	public String getfName() {
		return fName;
	}



	public void setfName(String fName) {
		this.fName = fName;
	}



	public String getlName() {
		return lName;
	}



	public void setlName(String lName) {
		this.lName = lName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getuserName() {
		return userName;
	}



	public void setuserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "user [user_id=" + user_id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", password="
				+ password + ", userName=" + userName + "]";
	}
	
		
	
	
	
	
	
}
