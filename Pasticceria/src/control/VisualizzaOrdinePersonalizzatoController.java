package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PagamentoIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class VisualizzaOrdinePersonalizzatoController {
	VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif;

	// costruttore
	public VisualizzaOrdinePersonalizzatoController(VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif) {
		this.visualizzaordinepersonalizzatoif = visualizzaordinepersonalizzatoif;

		this.visualizzaordinepersonalizzatoif.back(new back());
		this.visualizzaordinepersonalizzatoif.conferma(new conferma());
	}

	// gestione pulsante back
	class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			visualizzaordinepersonalizzatoif.setVisible(false); // modifica visibilità dell'interfaccia

		}

	}

	// gestione pulsante conferma
	class conferma implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			PagamentoIF pagamentoif = new PagamentoIF(); // interfaccia pagamento
			PagamentoController pagamentocontroller = new PagamentoController(pagamentoif,
					visualizzaordinepersonalizzatoif); // oggetto per gestire il pagamento
			pagamentoif.setVisible(true); // modifica visibilità interfaccia
		}

	}

}
