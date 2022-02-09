package com.revature.bank.DAOs;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.bank.models.Client;
import com.revature.bank.utilities.ConnectionFactory;
import com.revature.bank.utilities.LinkedList;
import com.revature.bank.utilities.List;

public class ClientDao implements CrudDAO<Client> {

	public Client findCredentials(String username, String password) {
				
		// trying to validate that the login credentials are valid
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql= "select * from clients where username = ? and password = ?";
			Statement s = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = s.executeQuery(sql);

			ps.setString(1, username);
			ps.setString(2, password);			

			//return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Invalid credentials");
		}
		return null;
	}



	@Override
	public Client create(Client newClient) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			newClient.setUser_id(UUID.randomUUID().toString());

			String sql = "insert into clients (user_id,fname,lname,email,username,password) values (?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newClient.getUser_id());
			ps.setString(2, newClient.getfName());
			ps.setString(3, newClient.getlName());
			ps.setString(4, newClient.getEmail());
			ps.setString(5, newClient.getuserName());
			ps.setString(6, newClient.getPassword());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted != 0) {
				return newClient;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Client> findAll() {
		
		List<Client> clientList = new LinkedList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from clients";
			Statement s = conn.createStatement();

			ResultSet resultSet = s.executeQuery(sql);

			while (resultSet.next()) {
				Client client = new Client();

				client.setUser_id(resultSet.getString("user_id"));
				client.setfName(resultSet.getString("fname"));
				client.setlName(resultSet.getString("lname"));
				client.setEmail(resultSet.getString("email"));
				client.setuserName(resultSet.getString("username"));
				client.setPassword(resultSet.getString("password"));
				
				clientList.add(client);
			}
			return clientList;

		} catch (Exception e) {

		}
		return null;

	}

	@Override
	public Client findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Client updateObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Client deleteObj) {
		// TODO Auto-generated method stub
		return false;
	}

}
