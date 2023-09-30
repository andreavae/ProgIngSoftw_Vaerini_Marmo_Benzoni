package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PagamentoIF;
import view.VisualizzaOrdineIF;

public class VisualizzaOrdineController {
	private VisualizzaOrdineIF visualizzaordineif;

	public VisualizzaOrdineController(VisualizzaOrdineIF visualizzaordineif) {
		this.visualizzaordineif = visualizzaordineif;

		this.visualizzaordineif.back(new back());
		this.visualizzaordineif.conferma(new conferma());
	}

	class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			visualizzaordineif.setVisible(false);

		}

	}

	class conferma implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			PagamentoIF pagamentoif = new PagamentoIF();
			PagamentoController pagamentocontroller = new PagamentoController(pagamentoif);
			pagamentoif.setVisible(true);
		}

	}
}
