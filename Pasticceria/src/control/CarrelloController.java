package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Carrello;
import model.Prodotto;
import model.User;
import view.NuovoOrdineIF;
import view.VisualizzaOrdineIF;

public class CarrelloController {
	private User utente;
	private NuovoOrdineIF nuovoordineif;
	private Carrello carrello;
	private Prodotto prodotto;

	public CarrelloController(User utente, NuovoOrdineIF nuovoordineif, Carrello carrello) {
		this.utente = utente;
		this.nuovoordineif = nuovoordineif;
		this.carrello = new Carrello();

		this.nuovoordineif.addCheesecake(new addCheesecake());
		this.nuovoordineif.addCubana(new addCubana());
		this.nuovoordineif.visualizzaOrdine(new visualizzaOrdine());
		this.nuovoordineif.back(new back());

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
			VisualizzaOrdineController visualizzaordinecontroller = new VisualizzaOrdineController(visualizzaordineif);
			visualizzaordineif.setVisible(true);
		}

	}

	class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			nuovoordineif.setVisible(false);

		}

	}
}
