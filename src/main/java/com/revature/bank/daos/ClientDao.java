package com.revature.bank.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Logger;

import com.revature.bank.models.Client;
import com.revature.bank.utilities.ConnectionFactory;
import com.revature.bank.utilities.LinkedList;
import com.revature.bank.utilities.List;

public class ClientDao implements CrudDAO<Client> {

	Logger logger = Logger.getLogger("src/main/resources/logger.txt");

	public Client findCredentials(String username, String password) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from clients where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Client client = new Client();
				client.setUser_id(rs.getString("user_id"));
				client.setfName(rs.getString("fname"));
				client.setlName(rs.getString("lname"));
				client.setEmail(rs.getString("email"));
				client.setuserName(rs.getString("username"));
				client.setPassword(rs.getString("password"));

				return client;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.info("CONNECTION FAILED TO AUTHENTICATE");
		}
		return null;
	}

	@Override
	public Client create(Client newClient) {

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
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from clients where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, id);
			ps.executeQuery();

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Client idClient = new Client();

				idClient.setUser_id(rs.getString("user_id"));
				idClient.setfName(rs.getString("fname"));
				idClient.setlName(rs.getString("lname"));
				idClient.setEmail(rs.getString("email"));
				idClient.setuserName(rs.getString("username"));
				idClient.setPassword(rs.getString("password"));

				return idClient;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

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
