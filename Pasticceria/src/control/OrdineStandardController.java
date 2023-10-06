package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Ordine;
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
	private Ordine ordine;

	public OrdineStandardController(User utente, OrdineStandardIF ordinestandardif, OrdineStandard carrello,
			HomeIF homeif, Ordine ordine) {
		this.utente = utente;
		this.ordinestandardif = ordinestandardif;
		this.homeif = homeif;
		this.ordine = ordine;
		this.carrello = new OrdineStandard(utente, 0);
		this.sconto = new Sconto();
		this.ordinestandardif.addCheesecake(new addCheesecake());
		this.ordinestandardif.addCubana(new addCubana());
		this.ordinestandardif.visualizzaOrdine(new visualizzaOrdine());
		this.ordinestandardif.back(new back());
	}

	// gestione prodotto
	class addCheesecake implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Prodotto Cheesecake = new Prodotto("Cheesecake", 15); // oggetto prodotto con nome e prezzo
			carrello.addProdotto(Cheesecake); // aggiunta al carrello
		}
	}

	// gestione prodotto
	class addCubana implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Prodotto Cubana = new Prodotto("Cubana", 12);
			carrello.addProdotto(Cubana); // aggiunta al carrello
		}

	}

	// gestione visualizzazione ordine
	class visualizzaOrdine implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(carrello.getCarrello()); // stampa contenuto carrello
			System.out.println(utente.isVipUser(utente.getUsername()));
			if (!utente.isVipUser(utente.getUsername())) { // se utente non è vip
				// visualizzazione carrello senza sconto sul totale
				VisualizzaOrdineIF visualizzaordineif = new VisualizzaOrdineIF(utente, carrello, 0);
				visualizzaordineif.setVisible(true);
				VisualizzaOrdineController visualizzaordinecontroller = new VisualizzaOrdineController(utente,
						visualizzaordineif, carrello, ordine);
			} else {
				// visualizzazione carrello con sconto giornaliero sul totale
				VisualizzaOrdineIF visualizzaordineif = new VisualizzaOrdineIF(utente, carrello, sconto.getSconto());
				visualizzaordineif.setVisible(true);
				VisualizzaOrdineController visualizzaordinecontroller = new VisualizzaOrdineController(utente,
						visualizzaordineif, carrello, ordine);
			}

		}

	}

	// gestione pulsante back
	class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// visibilità interfacce
			homeif.setVisible(true);
			ordinestandardif.setVisible(false);
		}

	}
}
