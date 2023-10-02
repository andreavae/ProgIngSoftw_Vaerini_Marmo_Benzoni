package model;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
	private List<Prodotto> carrello;

	public Carrello() {
		carrello = new ArrayList<Prodotto>();
	}

	public void addProdotto(Prodotto prodotto) {
		carrello.add(prodotto);
	}

	public List<Prodotto> getCarrello() {
		return carrello;
	}

	public float getTotale() {
		float conto = 0;
		for (Prodotto p : carrello) {
			conto = conto + p.getPrezzo();
		}
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
