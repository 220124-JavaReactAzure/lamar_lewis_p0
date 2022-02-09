package com.revature.bank.services;

import java.util.logging.Logger;

import com.revature.bank.DAOs.ClientDao;
import com.revature.bank.models.Client;
import com.revature.bank.util.assertNotNulll;
import com.revature.bank.utilities.List;
import com.revature.monster_lab.exceptions.InvalidRequestException;

public class ClientService {
	Logger logger = Logger.getLogger("src/main/resources/logger.txt");
	
	private ClientDao clientDao = new ClientDao(); 
	
	public boolean registerNewClient(Client newClient) {
		if(!isClientValid(newClient)) {
			throw new InvalidRequestException("Invalid User data provided");
		}
		clientDao.create(newClient);
		
		return true;
	}
	
	public List<Client> getAllClients(){
		
		return clientDao.findAll();
		
		
	}
	
	//this assists the Client Crud to do validation tasks
	
	// takes information from the client and validate them
	
	// try to authenticate credentials using prepared statements
	public Client authenticateClient(String username, String password) {
		clientDao.findCredentials(username, password);
		logger.info("Authenticated");
		return null;
	}
	
	public boolean isClientValid(Client newClient) {
		if(newClient==null) return false;
		if(newClient.getfName()== null || newClient.getfName().trim().equals("")) return false;
		if(newClient.getlName()== null || newClient.getlName().trim().equals("")) return false;
		if(newClient.getEmail()== null || newClient.getEmail().trim().equals("")) return false;
		if(newClient.getuserName()== null || newClient.getuserName().trim().equals("")) return false;
		return	newClient.getPassword() != null || !newClient.getPassword().trim().equals("");


	}

}
