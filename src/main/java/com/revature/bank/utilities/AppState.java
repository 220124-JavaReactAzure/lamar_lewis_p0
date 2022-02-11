package com.revature.bank.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.bank.menus.DashboardMenu;
import com.revature.bank.menus.LoginMenu;
import com.revature.bank.menus.RegisterMenu;
import com.revature.bank.menus.WelcomeMenu;
import com.revature.bank.services.AccountService;
import com.revature.bank.services.ClientService;

public class AppState {
	
	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		ClientService clientservice = new ClientService();
		AccountService accountservice = new AccountService();
		router.addMenu(new WelcomeMenu(consoleReader,router));
		router.addMenu(new LoginMenu(consoleReader,router,clientservice));
		router.addMenu(new RegisterMenu(consoleReader,router,clientservice));
		router.addMenu(new DashboardMenu(consoleReader,router,accountservice,clientservice));
	}
	
	public void startup() {
		
			try {
				while(isRunning) {
				router.transfer("/welcome");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		public static void shutDown() {
			isRunning = false;
		}
	}	
	


