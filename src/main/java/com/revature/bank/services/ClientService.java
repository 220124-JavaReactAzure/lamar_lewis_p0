package com.revature.bank.services;

import com.revature.bank.DAOs.ClientDao;
import com.revature.bank.models.Client;
import com.revature.bank.utilities.List;
import com.revature.monster_lab.exceptions.InvalidRequestException;

public class ClientService {
	
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
	
	// implement sql authentication 
	public Client authenticateClient(String username, String password) {
		clientDao.findCredentials(username, password);
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
