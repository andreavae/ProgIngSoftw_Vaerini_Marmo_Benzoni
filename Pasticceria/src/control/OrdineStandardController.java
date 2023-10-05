package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.OrdineStandard;
import model.Prodotto;
import model.Sconto;
import model.User;
import view.HomeIF;
import view.OrdineStandardIF;
import view.VisualizzaOrdineIF;

public class OrdineStandardController {
	private User utente;
	private OrdineStandardIF ordinestandardif;
	private OrdineStandard carrello;
	private Prodotto prodotto;
	private HomeIF homeif;
	private Sconto sconto;

	public OrdineStandardController(User utente, OrdineStandardIF ordinestandardif, OrdineStandard carrello,
			HomeIF homeif) {
		this.utente = utente;
		this.ordinestandardif = ordinestandardif;
		this.homeif = homeif;

		this.carrello = new OrdineStandard(utente, 0);
		this.sconto = new Sconto();
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
			System.out.println(utente.isVipUser(utente.getUsername()));
			if (!utente.isVipUser(utente.getUsername())) {
				VisualizzaOrdineIF visualizzaordineif = new VisualizzaOrdineIF(utente, carrello, 0);
				visualizzaordineif.setVisible(true);
				VisualizzaOrdineController visualizzaordinecontroller = new VisualizzaOrdineController(utente,
						visualizzaordineif, carrello);
			} else {
				VisualizzaOrdineIF visualizzaordineif = new VisualizzaOrdineIF(utente, carrello, sconto.getSconto());
				visualizzaordineif.setVisible(true);
				VisualizzaOrdineController visualizzaordinecontroller = new VisualizzaOrdineController(utente,
						visualizzaordineif, carrello);
			}

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
