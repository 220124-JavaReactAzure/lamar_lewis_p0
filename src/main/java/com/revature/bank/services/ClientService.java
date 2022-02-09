package com.revature.bank.services;

import java.io.File;
import java.io.FileWriter;

import com.revature.bank.models.Client;

public class ClientService {
	
	public boolean registerNewClient(Client newClient) {
		if(!isClientValid(newClient)) {
			throw new RuntimeException("Invalid User data provided");
		}
		
		File clientFile = new File("resources/data.txt");
		
		try(FileWriter filewriter = new FileWriter(clientFile, true);){
			filewriter.write(newClient.toFileString() + "\n");
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Client authenticateClient(String username, String password) {
		return null;
	}
	
	public boolean isClientValid(Client newClient) {
		if(newClient==null) return false;
		if(newClient.getfName()== null || newClient.getfName().trim().equals("")) return false;
		if(newClient.getlName()== null || newClient.getlName().trim().equals("")) return false;
		if(newClient.getEmail()== null || newClient.getEmail().trim().equals("")) return false;
		if(newClient.getUserName()== null || newClient.getUserName().trim().equals("")) return false;
		return	newClient.getPassword() != null || !newClient.getPassword().trim().equals("");


	}

}
