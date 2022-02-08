package com.revature.bank.menus;

import java.io.BufferedReader;
import static com.revature.bank.utilities.AppState.shutDown;

import com.revature.bank.utilities.MenuRouter;

public class WelcomeMenu extends Menu {
	
	

	public WelcomeMenu( BufferedReader consoleReader, MenuRouter router) {
		super("Welcome", "/welcome", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		System.out.println("Welcome to Bank of Lewis!\n" +"1) Login\n"+"2) Register\n"+"3) Exit\n");
		
		String userSelection = consoleReader.readLine();
		
		switch(userSelection) {
		case "1":
			router.transfer("/login");			
			break;
		case "2":
			router.transfer("/register");
			break;
		case "3":
			shutDown();
			break;
		default:
			System.out.println("Invalid selection");
			break;
		
		}
		
	}

}
