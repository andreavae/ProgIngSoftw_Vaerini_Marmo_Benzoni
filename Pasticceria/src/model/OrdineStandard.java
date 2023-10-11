package model;

import java.util.ArrayList;
import java.util.List;

public class OrdineStandard extends Ordine {
	private List<Prodotto> carrello;

	public OrdineStandard(User utente, double sconto) {
		super(utente);
		carrello = new ArrayList<Prodotto>();
	}

	// metodo per aggiungere il prodotto nel carrello
	public void addProdotto(Prodotto prodotto) {
		carrello.add(prodotto);
	}

	// ritorna i prodotti nel carrello
	public List<Prodotto> getCarrello() {
		return carrello;
	}

	// conto totale dei prodotti nel carrello
	public double getTotale(double sconto) {
		double conto = 0;
		for (Prodotto p : carrello) {
			conto = conto + p.getPrezzo(); // somma prezzi
		}
		conto = conto - conto * sconto; // applico sconto
		return conto;
	}

	// svuotare il carrello
	public List<Prodotto> svuotaCarrello() {
		carrello.clear(); // cancellare prodotti
		return carrello;
	}

	@Override // reppresentazione carrello
	public String toString() {
		return "Carrello [carrello=" + carrello + "]";
	}
}
