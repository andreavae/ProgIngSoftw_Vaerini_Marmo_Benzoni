package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.OrdinePersonalizzato;
import view.PagamentoIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class VisualizzaOrdinePersonalizzatoController {
	private VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif;
	private OrdinePersonalizzato ordinepersonalizzato2;

	// costruttore
	public VisualizzaOrdinePersonalizzatoController(VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif,
			OrdinePersonalizzato ordinpersonalizzato) {
		this.visualizzaordinepersonalizzatoif = visualizzaordinepersonalizzatoif;
		this.ordinepersonalizzato2 = ordinepersonalizzato2;

		this.visualizzaordinepersonalizzatoif.back(new back());
		this.visualizzaordinepersonalizzatoif.conferma(new conferma());
	}

	// gestione pulsante back
	class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			visualizzaordinepersonalizzatoif.setVisible(false); // modifica visibilit� dell'interfaccia

		}

	}

	// gestione pulsante conferma
	class conferma implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			PagamentoIF pagamentoif = new PagamentoIF(); // interfaccia pagamento
			PagamentoController pagamentocontroller = new PagamentoController(pagamentoif,
					visualizzaordinepersonalizzatoif); // oggetto per gestire il pagamento

			pagamentoif.setVisible(true); // modifica visibilit� interfaccia
		}

	}

}
