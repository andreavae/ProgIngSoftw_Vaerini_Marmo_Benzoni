package model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Abbonamento {

	private User utente;
	private String CODICE_ORDINE_GENERATO;
	private Set<String> CODICE_ORDINE_ASSEGNATI = new HashSet<String>();
	private final String codiceGenerato;

	public Abbonamento(User utente) {
		this.utente = utente;
		do {
			CODICE_ORDINE_GENERATO = generaCodiceOrdine();
		} while (CODICE_ORDINE_ASSEGNATI.contains(CODICE_ORDINE_GENERATO));
		this.codiceGenerato = CODICE_ORDINE_GENERATO;
		CODICE_ORDINE_ASSEGNATI.add(codiceGenerato);
	}

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

	// restutisce l'utente associato all'abbonamento
	public User getUtente() {
		return utente;
	}

	// restituisce codice abbonamento
	public String getId() {
		return codiceGenerato;
	}

}
