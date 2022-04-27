package com.taoliu.final510.models;



import com.taoliu.final510.dao.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientModel extends DBConnect {

	private int cid;
	private int tid;
	private double balance;

	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;

	public ClientModel() {

		conn = new DBConnect();
	}

	/* getters & setters */
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getTid() {
		return tid;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	// INSERT INTO METHOD
	public void insertRecord(int cid, double bal) {

		try {
			setCid(cid);
			// Execute a query
			System.out.println("Inserting record into the table...");
			stmt = conn.getConnection().createStatement();
			String sql = null;

			// Include data to the database table

			sql = " insert into jpapa_accounts(cid, balance) values('" + cid + "', '" + bal + "')";

			stmt.executeUpdate(sql);
			conn.getConnection().close();

			System.out.println("Balance inserted $" + bal + " for ClientID " + cid);

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public List<ClientModel> getAccounts(int cid) {
		List<ClientModel> accounts = new ArrayList<>();
		String query = "SELECT tid,balance FROM jpapa_accounts WHERE cid = ?;";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, cid);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ClientModel account = new ClientModel();
				// grab record data by table field name into ClientModel account object
				account.setTid(resultSet.getInt("tid"));
				account.setBalance(resultSet.getDouble("balance"));
				accounts.add(account); // add account data to arraylist
			}
		} catch (SQLException e) {
			System.out.println("Error fetching Accounts: " + e);
		}
		return accounts; // return arraylist
	}

}