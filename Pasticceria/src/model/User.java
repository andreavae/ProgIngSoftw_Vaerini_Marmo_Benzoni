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

	/**
	 * 
	 * @return true se l'username prelevato dall'interfaccia è presente sia nella
	 *         tabella utenti sia nella tabella utentipremium e inoltre se la
	 *         password associata a quell'utente corrisponde a quella prelevata
	 *         dall'interfaccia. Altrimenti false.
	 */

	public boolean isVipLoginValid() { // validazione login come vip
		ConnectingOnline connectdb = new ConnectingOnline("//127.0.0.1:3306/PasticceriaDB"); // percorso del db

		try {
			connectdb.connect(); // apertura connessione
			connectdb.setStatement(connectdb.getConnection().createStatement());

			String query = "SELECT utenti.Username FROM utenti INNER JOIN utentipremium ON utenti.Username = utentipremium.UsernameUtente"; // query
			ResultSet rs = connectdb.getStatement().executeQuery(query); // risultato query in rs

			ArrayList<String> listautentivip = new ArrayList<String>();
			while (rs.next()) { // aggiunta utenti
				listautentivip.add(rs.getString("Username"));
			}
			// logica per determinare se il login VIP � valido
			boolean corretto = false;
			boolean flagusername = listautentivip.contains(username);
			boolean flagpassword;

			if (flagusername) {
				String pass = null;
				String querypassword = "SELECT utenti.Password FROM utenti INNER JOIN utentipremium ON utenti.Username = utentipremium.UsernameUtente WHERE utenti.Username = '"
						+ username + "'"; // selezione password utente
				try {
					rs = connectdb.getStatement().executeQuery(querypassword); // risultato query
					if (rs.next()) { // ottenimnto password
						pass = rs.getString("Password");
						flagpassword = pass.equals(password); // true se pass � uguale alla password utente
						if (flagpassword) {
							corretto = true;
						}
					}
				} catch (SQLException e1) {

				}
			}
			return corretto;
		} catch (SQLException e) {
			// gestionel'eccezione
			e.printStackTrace();
			return false;
		} finally {
			// Chiudere la connessione e le risorse
			try {
				if (connectdb.getStatement() != null) {
					connectdb.getStatement().close();
				}
				if (connectdb.getConnection() != null) {
					connectdb.getConnection().close();
				}
			} catch (SQLException e) {
				// gestione eccezioni durante la chiusura
				e.printStackTrace();
			}

		}

	}

	public boolean isSignValid() { // verifica tentativo di validit� della registrazione
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
			// gestione eccezione
		}
		boolean corretto = false;
		boolean flagusername = listautenti.contains(username); // variabile usata per verificare se user � gia presente
		System.out.println(flagusername);
		if (!flagusername) { // username non presente
			String queryregistrazione = "INSERT INTO utenti (Username, Password) VALUES ('" + username + "','"
					+ password + "')"; // query di inserimento nel database
			listautenti.add(username);
			try {
				connectdb.setStatement(connectdb.getConnection().createStatement());
				connectdb.getStatement().executeUpdate(queryregistrazione);
			} catch (SQLException e) {

			}
		}

		boolean checkusername = listautenti.contains(username); // verifica se utente � inserito nell'arraylist
		return checkusername;

	}

	public boolean isVipUser(String username) { // verifica se un utente � vip
		ConnectingOnline connectdb = new ConnectingOnline("//127.0.0.1:3306/PasticceriaDB");

		try {
			connectdb.connect(); // connessione aperta
			connectdb.setStatement(connectdb.getConnection().createStatement());

			// query di selezione
			String query = "SELECT utenti.Username FROM utenti INNER JOIN utentipremium ON utenti.Username = utentipremium.UsernameUtente";
			// risultato query
			ResultSet rs = connectdb.getStatement().executeQuery(query);

			ArrayList<String> listautentivip = new ArrayList<String>();
			System.out.println(listautentivip);
			while (rs.next()) { // inserimento utenti
				listautentivip.add(rs.getString("Username"));
			}
			// logica per determinare se il login VIP � valido
			boolean corretto = false;
			boolean flagusername = listautentivip.contains(username);
			if (flagusername)
				return true;

		} catch (SQLException e) {

		}
		return false;
	}

	public boolean isSignVip(String username, int codice) {
		ConnectingOnline connectdb = new ConnectingOnline("//127.0.0.1:3306/PasticceriaDB"); // percorso database
		connectdb.connect(); // apro connessione

		ResultSet rs = null; // archivio risultati query
		ArrayList<String> listautenti = new ArrayList<String>(); // archivio utenti
		try {
			connectdb.setStatement(connectdb.getConnection().createStatement());
			String query = "SELECT" + username + " FROM utentipremium"; // query di selezione degli username
			rs = connectdb.getStatement().executeQuery(query);

			while (rs.next()) { // inserimeto utenti database nell'arraylist
				String usernameFromDB = rs.getString("Username");
				listautenti.add(usernameFromDB);

			}

		} catch (SQLException e) {
			// Gestisci gli errori di query SQL
		}
		boolean corretto = false;
		boolean flagusername = listautenti.contains(username);// variabile usata per verificare se user � gia presente

		System.out.println(flagusername);
		if (!flagusername) { // se non inserito allora inserisce nel db
			String queryregistrazione = "INSERT INTO utentipremium (CodAbbonamento, UsernameUtente) VALUES ('" + codice
					+ "','" + username + "')";
			listautenti.add(username);
			try {
				connectdb.setStatement(connectdb.getConnection().createStatement());
				connectdb.getStatement().executeUpdate(queryregistrazione);
			} catch (SQLException e) {

			}
		}
		boolean checkusername = listautenti.contains(username); // verifica se utente � inserito nell'arraylist
		return checkusername;

	}

}
