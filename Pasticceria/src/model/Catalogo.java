package model;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private List<Prodotto> catalogo;

	public Catalogo() {
		catalogo = new ArrayList<Prodotto>();
		catalogo.add(new Prodotto("P01", "Cheesecake", 5));
		catalogo.add(new Prodotto("P02", "Cubana", 10));
	}

	public List<Prodotto> getCatalogo() {
		return catalogo;
	}

}
