package model;

import java.util.HashSet;
import java.util.Set;

public class Abbonamento {
	private User utente;
	private static int COD_ABBONAMENTO_GENERATO = 0;
	private static Set<Integer> COD_ABBONAMENTO_ASSEGNATI = new HashSet<Integer>();
	private final int id;

	public Abbonamento(User utente) {
		COD_ABBONAMENTO_GENERATO++;
		if (COD_ABBONAMENTO_ASSEGNATI.contains(COD_ABBONAMENTO_GENERATO))
			throw new IllegalArgumentException("CODICE ABBONAMENTO NON DISPONIBILE");
		this.id = COD_ABBONAMENTO_GENERATO;
		COD_ABBONAMENTO_ASSEGNATI.add(id);
		this.utente = utente;
	}

	public User getUtente() {
		return utente;
	}

	public int getId() {
		return id;
	}

}
