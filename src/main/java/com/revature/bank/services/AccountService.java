package com.revature.bank.services;

import com.revature.bank.DAOs.AccountDAO;
import com.revature.bank.models.Accounts;
import com.revature.bank.models.Client;
import com.revature.monster_lab.exceptions.AuthenticationException;
import com.revature.monster_lab.exceptions.InvalidRequestException;
import com.revature.monster_lab.exceptions.ResourcePersistenceException;

public class AccountService {

	private Accounts sessionAccount;
	private Client client;
	private final AccountDAO accountDao;

	
	public AccountService() {
		this.accountDao = new AccountDAO();
	}
	
	public AccountService(AccountDAO accountDao) {
		this.accountDao = accountDao;
		this.sessionAccount = null;
	}
	public Accounts getSessionAccount() {
		return sessionAccount;
	}
	
	public Accounts registerNewAccount(Accounts newAccount) throws ResourcePersistenceException {
		
		 
		Accounts persistedAccount = accountDao.create(newAccount);

		

			return persistedAccount;
	}

	
	public void authenticateClient(String username, String password) throws AuthenticationException {

		if (username == null || password.trim().equals("") || password == null || password.trim().equals(""))
			throw new InvalidRequestException("Username or password invalid. try again");

		//Client authenticatedAccount = AccountDAO.findCredentials(account_no);

		//if (authenticatedAccount == null) {
			throw new AuthenticationException("Not authenticated, invalid login credentials");
			
		//}

		//sessionAccount = authenticatedAccount;

	}
	
	public boolean isSessionActive() {
		return sessionAccount != null;
	}
	public void logout() {
		sessionAccount = null;
	}
	
	public Accounts update(Accounts account) {
		boolean ac = accountDao.update(account);
		
		return null;
	}
	
	
	

}
