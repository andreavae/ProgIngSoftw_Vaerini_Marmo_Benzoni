package model;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private List<Prodotto> catalogo;

	public Catalogo() {
		catalogo = new ArrayList<Prodotto>();
		catalogo.add(new Prodotto("Cheesecake", "resources/cheesecake.jpg"));
		catalogo.add(new Prodotto("Cubana", "resources/cubana.jpg"));
	}

	public List<Prodotto> getCatalogo() {
		return catalogo;
	}

}
