package com.revature.bank.menus;

import java.io.BufferedReader;

import com.revature.bank.utilities.MenuRouter;

public class LoginMenu extends Menu {
	
		

	public LoginMenu( BufferedReader consoleReader, MenuRouter router) {
		super("Login", "/login", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	public void login(String email,String password) {
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
