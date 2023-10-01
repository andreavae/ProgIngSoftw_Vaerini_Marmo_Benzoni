package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Carrello;
import view.PagamentoIF;
import view.VisualizzaOrdineIF;

public class VisualizzaOrdineController {
	private VisualizzaOrdineIF visualizzaordineif;

	public VisualizzaOrdineController(VisualizzaOrdineIF visualizzaordineif) { // costruttore
		this.visualizzaordineif = visualizzaordineif;

		this.visualizzaordineif.back(new back()); // configurazione gestori
		this.visualizzaordineif.conferma(new conferma());
		this.visualizzaordineif.cancellaOrdine(new cancella());
	}

	class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { // gestione per pulsante back
			visualizzaordineif.setVisible(false);

		}

	}

	class conferma implements ActionListener { // gestione per pulsante conferma

		@Override
		public void actionPerformed(ActionEvent e) {
			PagamentoIF pagamentoif = new PagamentoIF();
			PagamentoController pagamentocontroller = new PagamentoController(pagamentoif);
			pagamentoif.setVisible(true);
		}

	}

	class cancella implements ActionListener { // gestione pulsante cancella

		@Override
		public void actionPerformed(ActionEvent e) {
			Carrello carrello = new Carrello();

		}

	}
}
