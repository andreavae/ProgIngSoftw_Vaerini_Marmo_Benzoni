package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PagamentoIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class VisualizzaOrdinePersonalizzatoController {
	VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif;

	public VisualizzaOrdinePersonalizzatoController(VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif) {
		this.visualizzaordinepersonalizzatoif = visualizzaordinepersonalizzatoif;

		this.visualizzaordinepersonalizzatoif.back(new back());
		this.visualizzaordinepersonalizzatoif.conferma(new conferma());
	}

	class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			visualizzaordinepersonalizzatoif.setVisible(false);

		}

	}

	class conferma implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			PagamentoIF pagamentoif = new PagamentoIF();
			PagamentoController pagamentocontroller = new PagamentoController(pagamentoif,
					visualizzaordinepersonalizzatoif);
			pagamentoif.setVisible(true);
		}

	}

}
