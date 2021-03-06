package com.revature.bank.menus;

import java.io.BufferedReader;
import java.util.logging.Logger;

import javax.naming.AuthenticationException;

import com.revature.bank.models.Client;
import com.revature.bank.services.ClientService;
import com.revature.bank.utilities.MenuRouter;

public class LoginMenu extends Menu {

	Logger logger = Logger.getLogger("src/main/resources/logger.txt");

	private final ClientService clientservice;

	public LoginMenu(BufferedReader consoleReader, MenuRouter router, ClientService clientservice) {
		super("Login", "/login", consoleReader, router);
		this.clientservice = clientservice;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {

		System.out.println("Please Enter your Account information");
		System.out.print("Username: ");
		String username = consoleReader.readLine();
		System.out.print("Password: ");
		String password = consoleReader.readLine();

		// attempt to establish connection
		// System.out.println(clientservice.toString());
		// clientservice.toString();

		try {
			clientservice.authenticateClient(username, password);
			logger.info("User Authenticated");
			// System.out.println(clientservice.));
			router.transfer("/dashboard");
		} catch (Exception e) {
			logger.info("AUTHENTICATION FAILED");
			System.out.println("Invalid Credentials, try again\n");
			router.transfer("/welcome");
		}

	}
}
