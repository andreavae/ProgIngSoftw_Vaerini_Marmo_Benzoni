
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import db.ConnectingOnline;

public class Ordine {

	private String CODICE_ORDINE_GENERATO;
	private Set<String> CODICE_ORDINE_ASSEGNATI = new HashSet<String>();
	public User utente;
	public ArrayList<Prodotto> ListaProd;
	// public StatoOrdine Stato;
	public double prezzoOrdine;
	private final String codiceOrdine;

	// costruttore
	public Ordine(User utente) { // associa utente all'ordine e genera un codice univoco
		this.utente = utente;
		do {
			CODICE_ORDINE_GENERATO = generaCodiceOrdine();
		} while (CODICE_ORDINE_ASSEGNATI.contains(CODICE_ORDINE_GENERATO));
		this.codiceOrdine = CODICE_ORDINE_GENERATO;
		CODICE_ORDINE_ASSEGNATI.add(codiceOrdine);

		this.prezzoOrdine = prezzoOrdine;
	}

	// metodo pee generare un codice ordine casuale
	private static String generaCodiceOrdine() {
		String caratteri = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // caratteri ammissibili
		int dimCodice = 10; // lunghezza codice
		Random random = new Random(); // ogetto per geneare numeri casuali
		StringBuilder builder = new StringBuilder(); // per costruire il codice
		for (int i = 0; i < dimCodice; i++) { // 10 ripetizioni
			int randomNumero = random.nextInt(caratteri.length()); // numero tra 0 e lunghezza scringa caratteri
			char randomChar = caratteri.charAt(randomNumero); // estrazione carattere alla posizione ottenuta
			builder.append(randomChar); // aggiunta carattere estratto
		}
		return builder.toString(); // ritorno dl codice
	}

	public ArrayList<Prodotto> getListaProd() {
		return ListaProd;
	}

	public User getUtente() {
		return utente;
	}

	public double getPrezzoOrdine() {
		return prezzoOrdine;
	}

	public String getCodiceOrdine() {
		return codiceOrdine;
	}

	public String getUsernameUtente() {
		return utente.getUsername();
	}

	public boolean isOrderValid(Ordine ordine, User utente, double prezzo) {
		ConnectingOnline connectdb = new ConnectingOnline("//127.0.0.1:3306/pasticceriadb"); // inserimento percorso
																								// database
		connectdb.connect(); // connessione aperta
		try {
			connectdb.setStatement(connectdb.getConnection().createStatement()); // per eseguire query
		} catch (SQLException e) {

		}

		ResultSet rs = null;
		String query = "SELECT Username FROM utenti"; // selezione username utenti
		try {
			rs = connectdb.getStatement().executeQuery(query);
		} catch (SQLException e) {

		}
		// inserimento username nell'arraylist
		ArrayList<String> listautenti = new ArrayList<String>();

		try {
			while (rs.next()) {
				listautenti.add(rs.getString("Username"));
			}
		} catch (SQLException e) {

		}
		boolean corretto = false;
		boolean flagusername = listautenti.contains(utente.getUsername()); // true se esiste nel db l'username
		if (flagusername) { // se true
			// query per l'inserimento dell'ordine nel database
			String queryUpdateOrdine = "INSERT INTO ordine (CodOrdine, Utente, Costo) VALUES ('"
					+ ordine.getCodiceOrdine() + "','" + ordine.getUsernameUtente() + "','" + prezzo + "')";
			System.out.println(queryUpdateOrdine);
			try {
				// inserimento effettivo dell'ordine
				connectdb.setStatement(connectdb.getConnection().createStatement());
				connectdb.getStatement().executeUpdate(queryUpdateOrdine);
			} catch (SQLException e) {

			}
		}
		return flagusername;
	}
}
