package com.revature.bank.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Logger;

import com.revature.bank.models.Accounts;
import com.revature.bank.models.Accounts;
import com.revature.bank.models.Accounts;
import com.revature.bank.models.Accounts;
import com.revature.bank.utilities.ConnectionFactory;
import com.revature.bank.utilities.LinkedList;
import com.revature.bank.utilities.List;

public class AccountDAO implements CrudDAO<Accounts> {
	
	static Logger logger = Logger.getLogger("src/main/resources/logger.txt");


	public Accounts findCred(String account_no) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from accounts where account_no = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account_no);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Accounts account = new Accounts();
				account.setAccount_no(rs.getString("account_no"));
				account.setBalance(rs.getDouble("balance"));
				account.setClient_id(rs.getString("client_id"));
				return account;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return null;
	}
	public static Accounts findByClientId(String client_id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from accounts where client_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, client_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Accounts account = new Accounts();
				account.setAccount_no(rs.getString("account_id"));
				account.setBalance(rs.getDouble("balance"));
				account.setClient_id(rs.getString("client_id"));
				return account;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return null;
	}

	@Override
	public Accounts create(Accounts newAccounts) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String acc_id = (UUID.randomUUID().toString());

			String sql = "insert into accounts (account_id,balance,client_id) values (?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, acc_id);
			ps.setDouble(2, newAccounts.getBalance());
			ps.setString(3, newAccounts.getClient_id());


			int rowsInserted = ps.executeUpdate();

			if (rowsInserted != 0) {
				return newAccounts;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Accounts> findAll(){
		return null;
		
	}
	public List<Accounts> findAll(String id) {
		// TODO Auto-generated method stub
		List<Accounts> accountList = new LinkedList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from accounts where client_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,id);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				Accounts account = new Accounts();

				account.setAccount_no(resultSet.getString("account_id"));
				account.setBalance(resultSet.getDouble("balance"));
				account.setClient_id(resultSet.getString("client_id"));

				accountList.add(account);
			}
			return accountList;

		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public Accounts findById(String id) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from accounts where account_no=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, id);
			ps.executeQuery();

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Accounts idAccounts = new Accounts();

				idAccounts.setAccount_no(rs.getString("account_id"));
				idAccounts.setBalance(rs.getDouble("balance"));
				idAccounts.setClient_id(rs.getString("client_id"));

				return idAccounts;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean update(Accounts currentAccount) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "update accounts set balance = ? where client_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, currentAccount.getBalance());
			ps.setString(2, currentAccount.getOwner_id());
			ps.executeUpdate();
			
			logger.info("...persisted database");

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;

	}
	
	

	@Override
	public boolean delete(Accounts deleteObj) {
		// TODO Auto-generated method stub
		return false;
	}

}
