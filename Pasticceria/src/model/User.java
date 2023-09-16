package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.ConnectingOnline;

public class User {
	private String username;
	private String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isLoginValid() {
		ConnectingOnline connectdb = new ConnectingOnline("//127.0.0.1:3306/pasticceriadb");
		connectdb.connect();
		try {
			connectdb.setStatement(connectdb.getConnection().createStatement());
		} catch (SQLException e) {

		}

		ResultSet rs = null;
		String query = "SELECT Username FROM utenti";
		try {
			rs = connectdb.getStatement().executeQuery(query);
		} catch (SQLException e) {

		}

		ArrayList<String> listautenti = new ArrayList<String>();

		try {
			while (rs.next()) {
				listautenti.add(rs.getString("Username"));
			}
		} catch (SQLException e) {

		}
		boolean corretto = false;
		boolean flagusername = listautenti.contains(username);

		boolean flagpassword;
		if (flagusername) {
			String pass = null;
			String querypassword = "SELECT Password FROM utenti WHERE Username = '" + username + "'";
			try {
				rs = connectdb.getStatement().executeQuery(querypassword);
				if (rs.next()) {
					pass = rs.getString("Password");
					flagpassword = pass.equals(password);
					if (flagpassword) {
						corretto = true;
					}
				}
			} catch (SQLException e) {

			}
		}
		connectdb.close();
		return corretto;

	}
}
