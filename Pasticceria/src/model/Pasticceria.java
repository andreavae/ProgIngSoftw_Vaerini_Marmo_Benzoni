
package model;

import java.util.ArrayList;

public class Pasticceria {

	public String Nome;
	public ArrayList<Ordine> ordine;

	public Pasticceria(ArrayList<Ordine> ordine) {
		this.Nome = "BYTE DI DOLCEZZA";
		this.ordine = ordine;
	}

	public void AccettaOrdine(int codOrd) {
		for (Ordine O : ordine) {
			if (codOrd == O.getNOrdine()) {
				O.setStato(StatoOrdine.ACCETTATO);
			}
		}
	}

	public void Lavorazione(int codOrd) {
		for (Ordine O : ordine) {
			if (codOrd == O.getNOrdine()) {
				O.setStato(StatoOrdine.LAVORAZIONE);
			}
		}
	}

	public void Terminazione(int codOrd) {
		for (Ordine O : ordine) {
			if (codOrd == O.getNOrdine()) {
				O.setStato(StatoOrdine.TERMINATO);
			}
		}
	}

}