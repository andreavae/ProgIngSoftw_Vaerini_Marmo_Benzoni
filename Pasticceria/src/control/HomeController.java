package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.User;
import view.HomeIF;
import view.NuovoOrdineIF;

public class HomeController {
	private HomeIF homeif;
	private User utente;

	public HomeController(HomeIF homeif, User utente) {
		this.homeif = homeif;
		this.utente = utente;

		this.homeif.openNuovoOrdineIF(new openNuovoOrdineIF());
	}

	class openNuovoOrdineIF implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			NuovoOrdineIF nuovoordineif = new NuovoOrdineIF(utente);
			CarrelloController carrellocontroller = new CarrelloController(utente, nuovoordineif, null);
			// Catalogo catalogo = new Catalogo();
			// OrdineController ordinecontroller = new OrdineController(null);
			// Prodotto prodotto = new Prodotto("Nome Prodotto",
			// "resources/cheesecake.jpg");
			nuovoordineif.setVisible(true);

		}

	}

}
