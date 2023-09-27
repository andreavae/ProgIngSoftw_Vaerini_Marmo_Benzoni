package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.ConnectingOnline;

public class User {
	private String username; // dichiarazione variabili
	private String password;

	public User(String username, String password) { // costruttore
		this.username = username;
		this.password = password;
	}

	public String getUsername() { // ottiene username
		return username;
	}

	public String getPassword() { // ottiene password
		return password;
	}

	public boolean isLoginValid() { // effettua una verifica dell'accesso confrontando l'username e la password
									// inseriti con quelli memorizzati nel database
		ConnectingOnline connectdb = new ConnectingOnline("//127.0.0.1:3306/pasticceriadb"); // percorso database
		connectdb.connect(); // apre connessione
		try {
			connectdb.setStatement(connectdb.getConnection().createStatement());
		} catch (SQLException e) {

		}

		ResultSet rs = null;
		String query = "SELECT Username FROM utenti"; // query
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
		boolean flagusername = listautenti.contains(username); // variabile per verifica username

		boolean flagpassword; // variabile per verifica password
		if (flagusername) { // verifica di username,
			String pass = null;
			String querypassword = "SELECT Password FROM utenti WHERE Username = '" + username + "'"; // username true,
																										// si cerca la
																										// password
																										// associata
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
		connectdb.close(); // chiusura connessione database
		return corretto;

	}

	public boolean isSignValid() { // verifica tentativo di validità della registrazione
		ConnectingOnline connectdb = new ConnectingOnline("//127.0.0.1:3306/PasticceriaDB"); // percorso database
		connectdb.connect(); // apro connessione

		ResultSet rs = null; // archivio risultati query
		ArrayList<String> listautenti = new ArrayList<String>(); // archivio utenti

		try {
			connectdb.setStatement(connectdb.getConnection().createStatement());
			String query = "SELECT Username FROM utenti"; // query di selezione degli username
			rs = connectdb.getStatement().executeQuery(query);

			while (rs.next()) { // inserimeto utenti database nell'arraylist
				String usernameFromDB = rs.getString("Username");
				listautenti.add(usernameFromDB);

			}

		} catch (SQLException e) {
			// Gestisci gli errori di query SQL
		}
		boolean corretto = false;
		boolean flagusername = listautenti.contains(username); // variabile usata per verificare se user è gia presente
		System.out.println(flagusername);
		if (!flagusername) { // username non presente
			String queryregistrazione = "INSERT INTO utenti (Username, Password) VALUES ('" + username + "','"
					+ password + "')"; // query di inserimento nel database
			try {
				connectdb.setStatement(connectdb.getConnection().createStatement());
				connectdb.getStatement().executeUpdate(queryregistrazione);
			} catch (SQLException e) {

			}
		}

		boolean checkusername = listautenti.contains(username); // verifica se utente è inserito nell'arraylist
		return checkusername;

	}
}
