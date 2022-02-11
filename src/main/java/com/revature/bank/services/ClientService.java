package com.revature.bank.services;

import com.revature.bank.DAOs.ClientDao;
import com.revature.bank.models.Client;
import com.revature.bank.utilities.List;
import com.revature.monster_lab.exceptions.AuthenticationException;
import com.revature.monster_lab.exceptions.InvalidRequestException;
import com.revature.monster_lab.exceptions.ResourcePersistenceException;

public class ClientService {
	
	private Client sessionClient;
	private final ClientDao clientDao;
	

	public ClientService() {
		//super;
		this.clientDao = new ClientDao();
		//super();
		// TODO Auto-generated constructor stub
	}
	

	public ClientService(ClientDao clientDao) {
		this.clientDao = clientDao;
		this.sessionClient = null;
	}

	public Client getSessionClient() {
		return sessionClient;
	}
	
	public String id;

	public Client registerNewClient(Client newClient) throws ResourcePersistenceException {
		if (!isClientValid(newClient)) {
			throw new InvalidRequestException("Invalid User data provided");
		}

		boolean usernameAvailable = clientDao.findById(newClient.getuserName()) == null;
		boolean emailAvailable = clientDao.findById(newClient.getuserName()) == null;

		if (!usernameAvailable || !emailAvailable) {
			if (!usernameAvailable && emailAvailable) {
				throw new ResourcePersistenceException("Username taken");
			} else if (usernameAvailable) {
				throw new ResourcePersistenceException("email taken");
			} else {
				throw new ResourcePersistenceException("Email and Username taken");
			}
		}

		Client persistedClient = clientDao.create(newClient);

		if (persistedClient == null) {
			throw new ResourcePersistenceException("Client could not be persisted");
		}
		
		

			return persistedClient;
	}

	public List<Client> getAllClients() {

		return clientDao.findAll();

	}
	

	// this assists the Client Crud to do validation tasks
	// takes information from the client and validate them
	// try to authenticate credentials using prepared statements

	public void authenticateClient(String username, String password) throws AuthenticationException {

		if (username == null || password.trim().equals("") || password == null || password.trim().equals(""))
			throw new InvalidRequestException("Username or password invalid. try again");

		Client authenticatedClient = clientDao.findCredentials(username, password);

		if (authenticatedClient == null) {
			throw new AuthenticationException("Not authenticated, invalid login credentials");
			
		}

		sessionClient = authenticatedClient;

	}

	public void logout() {
		sessionClient = null;
	}

	public boolean isSessionActive() {
		return sessionClient != null;
	}

	public boolean isClientValid(Client newClient) {
		if (newClient == null)
			return false;
		if (newClient.getfName() == null || newClient.getfName().trim().equals(""))
			return false;
		if (newClient.getlName() == null || newClient.getlName().trim().equals(""))
			return false;
		if (newClient.getEmail() == null || newClient.getEmail().trim().equals(""))
			return false;
		if (newClient.getuserName() == null || newClient.getuserName().trim().equals(""))
			return false;
		return newClient.getPassword() != null || !newClient.getPassword().trim().equals("");

	}

}
