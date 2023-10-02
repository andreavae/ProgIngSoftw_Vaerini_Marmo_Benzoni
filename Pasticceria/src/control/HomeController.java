package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Carrello;
import model.User;
import view.HomeIF;
import view.OrdinePersonalizzatoIF;
import view.OrdineStandardIF;

public class HomeController {
	private HomeIF homeif;
	private User utente;
	private Carrello carrello;

	public HomeController(HomeIF homeif, User utente) {
		this.homeif = homeif;
		this.utente = utente;
		carrello = new Carrello();
		this.homeif.openNuovoOrdineIF(new openNuovoOrdineIF());
		this.homeif.openOrdinePersonalizzato(new openOrdinePersonalizzatoIF());

	}

	class openNuovoOrdineIF implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			OrdineStandardIF ordinestandardif = new OrdineStandardIF(utente);
			OrdineStandardController carrellocontroller = new OrdineStandardController(utente, ordinestandardif,
					carrello, homeif);
			// Catalogo catalogo = new Catalogo();
			// OrdineController ordinecontroller = new OrdineController(null);
			// Prodotto prodotto = new Prodotto("Nome Prodotto",
			// "resources/cheesecake.jpg");
			ordinestandardif.setVisible(true);

		}

	}

	class openOrdinePersonalizzatoIF implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			OrdinePersonalizzatoIF ordinepersonalizzatoif = new OrdinePersonalizzatoIF(utente);
			OrdinePersonalizzatoController ordinepersonalizzatocontroller = new OrdinePersonalizzatoController(utente,
					ordinepersonalizzatoif);
			ordinepersonalizzatoif.setVisible(true);

		}

	}

}
