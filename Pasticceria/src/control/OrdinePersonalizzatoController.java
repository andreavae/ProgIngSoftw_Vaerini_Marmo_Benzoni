package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.User;
import view.OrdinePersonalizzatoIF;

public class OrdinePersonalizzatoController {
	private User utente;
	private OrdinePersonalizzatoIF ordinepersonalizzatoif;

	public OrdinePersonalizzatoController(User utente, OrdinePersonalizzatoIF ordinepersonalizzatoif) {
		this.utente = utente;
		this.ordinepersonalizzatoif = ordinepersonalizzatoif;

		this.ordinepersonalizzatoif.back(new back());
	}

	class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ordinepersonalizzatoif.setVisible(false);

		}

	}
}
