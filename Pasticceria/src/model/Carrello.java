package model;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
	private User utente;
	private List<Prodotto> carrello;
	private double sconto;

	public Carrello(User utente, double sconto) {
		this.sconto = sconto;
		this.utente = utente;
		carrello = new ArrayList<Prodotto>();
	}

	public void addProdotto(Prodotto prodotto) {
		carrello.add(prodotto);
	}

	public List<Prodotto> getCarrello() {
		return carrello;
	}

	public double getTotale(double sconto) {
		double conto = 0;
		for (Prodotto p : carrello) {
			conto = conto + p.getPrezzo();
		}
		conto = conto - conto * sconto;
		return conto;
	}

	public List<Prodotto> svuotaCarrello() {
		carrello.clear();
		return carrello;
	}

	@Override
	public String toString() {
		return "Carrello [carrello=" + carrello + "]";
	}
}
