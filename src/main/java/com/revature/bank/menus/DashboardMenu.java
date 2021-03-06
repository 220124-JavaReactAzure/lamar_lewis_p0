package com.revature.bank.menus;

import java.io.BufferedReader;
import java.util.logging.Logger;

import com.revature.bank.DAOs.AccountDAO;
import com.revature.bank.models.Accounts;
import com.revature.bank.models.Client;
import com.revature.bank.services.AccountService;
import com.revature.bank.services.ClientService;
import com.revature.bank.utilities.MenuRouter;
import com.revature.monster_lab.exceptions.InvalidRequestException;

public class DashboardMenu extends Menu {

	Logger logger = Logger.getLogger("src/main/resources/logger.txt");

	AccountService accountService;
	ClientService clientservice;
	AccountDAO dao;

	public DashboardMenu(BufferedReader consoleReader, MenuRouter router, AccountService accountService,
			ClientService clientservice) {
		super("Dashboard", "/dashboard", consoleReader, router);
		this.accountService = accountService;
		this.clientservice = clientservice;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		Client currentClient = clientservice.getSessionClient();

		System.out.println(
				"\n\nChoose an option\n \n1) Create Account \n2) Deposit \n3) Withdraw \n4) View Account Balance \n5) Exit ");
		String option = consoleReader.readLine();

		switch (option) {
		case "1":
			System.out.println("How much money will you open your account with ?: ");
			String balance = consoleReader.readLine();
			Double bal = Double.valueOf(balance);

			Accounts account = new Accounts(currentClient.getUser_id(), bal);
			try {
				accountService.registerNewAccount(account);
				logger.info("OPENED ACCOUNT WITH, $" + bal);
			} catch (InvalidRequestException e) {
				System.out.println("Account not created, try again \n");
				router.transfer("/dashboard");
			}
			router.transfer("/dashboard");
			break;
		case "2":
			System.out.println("Enter deposit ammount: ");
			String deposit = consoleReader.readLine();
			Double dep = Double.valueOf(deposit);

			if (dep > 0) {
				try {
					Accounts currentAccount = AccountDAO.findByClientId(currentClient.getUser_id());
					currentAccount.setBalance(dep + currentAccount.getBalance());
					AccountDAO.update(currentAccount);
					logger.info("DEPOSITED MONEY, $" + dep);

				} catch (InvalidRequestException e) {

				}
				logger.info("....SUCCESSFULL DEPOSIT....");
			}

			router.transfer("/dashboard");
			break;
		case "3":
			System.out.println("Enter withdrawal ammount: ");
			String wd = consoleReader.readLine();
			Double withd = Double.valueOf(wd);
			Accounts currentAccount = AccountDAO.findByClientId(currentClient.getUser_id());

			if (withd > 0 && currentAccount.getBalance() - withd >= 0) {
				try {
					currentAccount.setBalance(currentAccount.getBalance() - withd);
					AccountDAO.update(currentAccount);
					logger.info("WITHDREW MONEY, $" + withd);
					router.transfer("/dashboard");

				} catch (InvalidRequestException e) {

				}
				router.transfer("/dashboard");

			}
			logger.info("...OVERDRAFT NOT ALLOWED...");
			router.transfer("/dashboard");
			break;
		case "4":
			System.out.println("Your Account balance is: ");
			Accounts currentAccount2 = AccountDAO.findByClientId(currentClient.getUser_id());
			System.out.println(currentAccount2.getBalance());
			logger.info("PRINTED ACCOUNT BALANCE, $" + currentAccount2.getBalance());
			router.transfer("/dashboard");
			break;
		case "5":
			logger.info("...RETURN TO MAIN MENU...\n");
			break;
		default:
			System.out.println("Invalid selection try again");
			router.transfer("/dashboard");
		}

	}

}
