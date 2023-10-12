
package model;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private List<Prodotto> catalogo;
	private static Catalogo istance = null; // istanza unica

	private Catalogo() {
		catalogo = new ArrayList<Prodotto>(); // lista prodotti
		// aggiunta prodotti al catalogo
		catalogo.add(new Prodotto("Cheesecake", "resources/cheesecake.jpg", 15));
		catalogo.add(new Prodotto("Cubana", "resources/cubana.jpg", 12));
		catalogo.add(new Prodotto("Cream Tart", "resources/Cream-tart.jpg", 20));
		catalogo.add(new Prodotto("Iris", "resources/Iris.jpg", 23));
		catalogo.add(new Prodotto("Mimosa", "resources/mimosa.jpg", 20));
		catalogo.add(new Prodotto("Saint Honorè", "resources/Saint-honorè.jpg", 25));
		catalogo.add(new Prodotto("Sacher", "resources/Sacher.jpg", 18));
		catalogo.add(new Prodotto("Setteveli", "resources/Setteveli.jpg", 15));
		catalogo.add(new Prodotto("Tiramisè", "resources/Tiramisu.jpg", 16));

	}

	// metodo per ottenere l'istanza unica del catalogo
	public static Catalogo getIstance() {
		if (istance == null) {
			istance = new Catalogo();
		}
		return istance;
	}

	// ritorno del catalogo
	public List<Prodotto> getCatalogo() {
		return catalogo;
	}

}
