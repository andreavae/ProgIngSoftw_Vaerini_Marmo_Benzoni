
package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Ordine {

	private String CODICE_ORDINE_GENERATO;
	private Set<String> CODICE_ORDINE_ASSEGNATI = new HashSet<String>();
	public User utente;
	public ArrayList<Prodotto> ListaProd;
	public StatoOrdine Stato;
	public double prezzoOrdine;
	private final String codiceOrdine;

	public Ordine(User utente) { // devo inserire
		this.utente = utente; // la data??
		do {
			CODICE_ORDINE_GENERATO = generaCodiceOrdine();
		} while (CODICE_ORDINE_ASSEGNATI.contains(CODICE_ORDINE_GENERATO));
		this.codiceOrdine = CODICE_ORDINE_GENERATO;
		CODICE_ORDINE_ASSEGNATI.add(codiceOrdine);
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

}
