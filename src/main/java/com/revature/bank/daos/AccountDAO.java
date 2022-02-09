package com.revature.bank.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.bank.models.Accounts;
import com.revature.bank.utilities.ConnectionFactory;
import com.revature.bank.utilities.List;

public class AccountDAO implements CrudDAO<Accounts> {
	
	
	
	public Accounts findCred(String account_n0, double balance) {
		
		/*try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql= "select * from clients where username = ? and password = ?";
			Statement s = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = s.executeQuery(sql);

			ps.setString(1, username);
			ps.setString(2, password);			

			//return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; */
		return null;
	}

	@Override
	public Accounts create(Accounts newObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Accounts> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accounts findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Accounts updateObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Accounts deleteObj) {
		// TODO Auto-generated method stub
		return false;
	}

}
