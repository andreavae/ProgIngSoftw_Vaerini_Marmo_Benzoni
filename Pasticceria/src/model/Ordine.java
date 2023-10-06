
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
	public StatoOrdine Stato;
	public double prezzoOrdine;
	private final String codiceOrdine;
	private TipoOrdine tipoOrdine;

	public Ordine(User utente, double prezzoOrdine) { // devo inserire
		this.utente = utente; // la data??
		do {
			CODICE_ORDINE_GENERATO = generaCodiceOrdine();
		} while (CODICE_ORDINE_ASSEGNATI.contains(CODICE_ORDINE_GENERATO));
		this.codiceOrdine = CODICE_ORDINE_GENERATO;
		CODICE_ORDINE_ASSEGNATI.add(codiceOrdine);
		this.tipoOrdine = tipoOrdine;
		this.prezzoOrdine = prezzoOrdine;
	}

	private static String generaCodiceOrdine() {
		String caratteri = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int dimCodice = 10;
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < dimCodice; i++) {
			int randomNumero = random.nextInt(caratteri.length());
			char randomChar = caratteri.charAt(randomNumero);
			builder.append(randomChar);
		}
		return builder.toString();
	}

	public ArrayList<Prodotto> getListaProd() {
		return ListaProd;
	}

	public StatoOrdine getStato() {
		return Stato;
	}

	public void setStato(StatoOrdine Stato) {
		this.Stato = Stato;
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

	public TipoOrdine getTipoOrdine() {
		return tipoOrdine;
	}

	public void setTipoOrdine(TipoOrdine tipoOrdine) {
		this.tipoOrdine = tipoOrdine;
	}

	public boolean isOrderValid(Ordine ordine, User utente, double prezzo, TipoOrdine tipoOrdine) {
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
		boolean flagusername = listautenti.contains(utente.getUsername());
		if (flagusername) {
			String queryUpdateOrdine = "INSERT INTO ordine (CodOrdine, Utente, TipoOrdine, Costo) VALUES ('"
					+ ordine.getCodiceOrdine() + "','" + ordine.getUsernameUtente() + "','" + ordine.getTipoOrdine()
					+ "','" + ordine.getPrezzoOrdine() + "')";
			System.out.println(queryUpdateOrdine);
			try {
				connectdb.setStatement(connectdb.getConnection().createStatement());
				connectdb.getStatement().executeUpdate(queryUpdateOrdine);
			} catch (SQLException e) {

			}
		}
		return flagusername;
	}
}
