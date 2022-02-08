package com.revature.bank.menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.revature.bank.utilities.MenuRouter;

public class RegisterMenu extends Menu {
	
	

	public RegisterMenu( BufferedReader consoleReader, MenuRouter router) {
		super("Register", "/register", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	private String fName;
	private String lName;
	private String dob;
	protected String email;
	protected String password;

	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your first name: ");
		fName = sc.next();
		System.out.println("Please enter your last name: ");
		lName = sc.next();
		System.out.println("Please enter your Date of birth: ");
		dob = sc.next();
		System.out.println("Please enter your Email: ");
		email = sc.next();
		System.out.println("Please enter your password: ");
		password = sc.next();
		
		writeFile(fName, lName, dob, email, password);
		
	}
	
	public void writeFile(String fName,String lName,String dob,String email,String password) {
		Path database = Paths.get("/Project0/database");
		
	
		
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
