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

	public boolean isSignValid() {
		ConnectingOnline connectdb = new ConnectingOnline("//127.0.0.1:3306/PasticceriaDB");
		connectdb.connect();

		ResultSet rs = null;
		ArrayList<String> listautenti = new ArrayList<String>();

		try {
			connectdb.setStatement(connectdb.getConnection().createStatement());
			String query = "SELECT Username FROM utenti";
			rs = connectdb.getStatement().executeQuery(query);

			while (rs.next()) {
				String usernameFromDB = rs.getString("Username");
				listautenti.add(usernameFromDB);

			}

		} catch (SQLException e) {
			// Gestisci gli errori di query SQL qui
		}
		boolean corretto = false;
		boolean flagusername = listautenti.contains(username);
		System.out.println(flagusername);
		if (!flagusername) {
			String queryregistrazione = "INSERT INTO utenti (Username, Password) VALUES ('" + username + "','"
					+ password + "')";
			try {
				connectdb.setStatement(connectdb.getConnection().createStatement());
				connectdb.getStatement().executeUpdate(queryregistrazione);
			} catch (SQLException e) {

			}
		}

		boolean checkusername = listautenti.contains(username);
		return checkusername;

	}
}
