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

	@Override
	public String toString() {
		return "Carrello [carrello=" + carrello + "]";
	}
}
