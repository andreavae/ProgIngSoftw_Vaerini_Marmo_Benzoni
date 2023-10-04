package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.VisualizzaOrdinePersonalizzatoIF;

public class VisualizzaOrdinePersonalizzatoController {
	VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif;

	public VisualizzaOrdinePersonalizzatoController(VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif) {
		this.visualizzaordinepersonalizzatoif = visualizzaordinepersonalizzatoif;

		this.visualizzaordinepersonalizzatoif.back(new back());
	}

	class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			visualizzaordinepersonalizzatoif.setVisible(false);

		}

	}
}
