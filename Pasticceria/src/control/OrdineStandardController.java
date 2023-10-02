package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Carrello;
import model.Prodotto;
import model.User;
import view.HomeIF;
import view.OrdineStandardIF;
import view.VisualizzaOrdineIF;

public class OrdineStandardController {
	private User utente;
	private OrdineStandardIF ordinestandardif;
	private Carrello carrello;
	private Prodotto prodotto;
	private HomeIF homeif;

	public OrdineStandardController(User utente, OrdineStandardIF ordinestandardif, Carrello carrello, HomeIF homeif) {
		this.utente = utente;
		this.ordinestandardif = ordinestandardif;
		this.homeif = homeif;

		this.carrello = new Carrello();

		this.ordinestandardif.addCheesecake(new addCheesecake());
		this.ordinestandardif.addCubana(new addCubana());
		this.ordinestandardif.visualizzaOrdine(new visualizzaOrdine());
		this.ordinestandardif.back(new back());
	}

	class addCheesecake implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Prodotto Cheesecake = new Prodotto("Cheesecake", 15);
			carrello.addProdotto(Cheesecake);
		}
	}

	class addCubana implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Prodotto Cubana = new Prodotto("Cubana", 12);
			carrello.addProdotto(Cubana);
		}

	}

	class visualizzaOrdine implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(carrello.getCarrello());
			VisualizzaOrdineIF visualizzaordineif = new VisualizzaOrdineIF(carrello);
			VisualizzaOrdineController visualizzaordinecontroller = new VisualizzaOrdineController(visualizzaordineif,
					carrello);
			visualizzaordineif.setVisible(true);
		}

	}

	class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			homeif.setVisible(true);
			ordinestandardif.setVisible(false);
		}

	}
}
