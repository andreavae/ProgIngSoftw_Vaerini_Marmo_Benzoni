package model;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private List<Prodotto> catalogo;

	public Catalogo() {
		catalogo = new ArrayList<Prodotto>(); // lista prodotti
		// aggiunta prodotti al catalogo
		catalogo.add(new Prodotto("Cheesecake", "resources/cheesecake.jpg"));
		catalogo.add(new Prodotto("Cubana", "resources/cubana.jpg"));
		catalogo.add(new Prodotto("Cream Tart", "resources/Cream-tart.jpg"));
		catalogo.add(new Prodotto("Iris", "resources/Iris.jpg"));
		catalogo.add(new Prodotto("Mimosa", "resources/mimosa.jpg"));
		catalogo.add(new Prodotto("Saint Honor�", "resources/Saint-honor�.jpg"));
		catalogo.add(new Prodotto("Sacher", "resources/Sacher.jpg"));
		catalogo.add(new Prodotto("Setteveli", "resources/Setteveli.jpg"));
		catalogo.add(new Prodotto("Tiramis�", "resources/Tiramisu.jpg"));
	}

	// ritorno del catalogo
	public List<Prodotto> getCatalogo() {
		return catalogo;
	}

}
