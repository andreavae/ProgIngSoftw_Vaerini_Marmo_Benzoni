package model;

import java.util.HashSet;
import java.util.Set;

public class Abbonamento {
	private User utente;
	private static int COD_ABBONAMENTO_GENERATO = 0;
	private static Set<Integer> COD_ABBONAMENTO_ASSEGNATI = new HashSet<Integer>(); // per conservare elementi unici
	private final int id;

	public Abbonamento(User utente) {
		COD_ABBONAMENTO_GENERATO++; // per generare un identificatore univoco dell'abbonamento
		if (COD_ABBONAMENTO_ASSEGNATI.contains(COD_ABBONAMENTO_GENERATO)) // verifica codici uguali
			throw new IllegalArgumentException("CODICE ABBONAMENTO NON DISPONIBILE"); // errore
		this.id = COD_ABBONAMENTO_GENERATO; // valore unico
		COD_ABBONAMENTO_ASSEGNATI.add(id); // codice aggiunto
		this.utente = utente;
	}

	// restutisce l'utente associato all'abbonamento
	public User getUtente() {
		return utente;
	}

	// restituisce codice abbonamento
	public int getId() {
		return id;
	}

}
