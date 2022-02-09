package com.revature.bank.menus;
import java.io.BufferedReader;
import java.util.logging.Logger;

import com.revature.bank.models.Client;
import com.revature.bank.services.ClientService;
import com.revature.bank.utilities.MenuRouter;
import com.revature.monster_lab.exceptions.InvalidRequestException;

public class RegisterMenu extends Menu {
	
	Logger logger = Logger.getLogger("src/main/resources/logger.txt");
	
	ClientService clientservice;

	public RegisterMenu( BufferedReader consoleReader, MenuRouter router, ClientService clientservice) {
		super("Register", "/register", consoleReader, router);
		this.clientservice = clientservice;
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		logger.info("Initiate user registration");
		
		System.out.println("Please enter your first name: ");
		String fName = consoleReader.readLine();
		System.out.println("Please enter your Last name: ");
		String lName = consoleReader.readLine();
		System.out.println("Please enter your email ");
		String email = consoleReader.readLine();
		System.out.println("Please enter your user name: ");
		String userName = consoleReader.readLine();
		System.out.println("Please enter your password: ");
		String password = consoleReader.readLine();	
	
		Client client = new Client(fName,lName,email,password,userName);
	
		System.out.printf("Provided by user: %s\n",client.toString()).println();
	
		try {
			clientservice.registerNewClient(client);
			logger.info("successfully created account");
		} catch(InvalidRequestException e) {
			System.out.println("Invalid data entered, try again \n");
			router.transfer("/welcome");
		}	
	}	

}
