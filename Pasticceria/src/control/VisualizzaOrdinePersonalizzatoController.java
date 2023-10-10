package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Ordine;
import model.OrdinePersonalizzato;
import model.User;
import view.LoginIF;
import view.PagamentoIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class VisualizzaOrdinePersonalizzatoController {
	private User utente;
	private VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif;
	private OrdinePersonalizzato ordinepersonalizzato;
	private LoginIF loginif;
	private Ordine ordine;

	// costruttore
	public VisualizzaOrdinePersonalizzatoController(User utente,
			VisualizzaOrdinePersonalizzatoIF visualizzaordinepersonalizzatoif, OrdinePersonalizzato ordinpersonalizzato,
			LoginIF loginif) {
		this.utente = utente;
		this.visualizzaordinepersonalizzatoif = visualizzaordinepersonalizzatoif;
		this.ordine = ordine;
		this.ordinepersonalizzato = ordinepersonalizzato;
		System.out.println("VisualizzaOrdinePersonalizzatoController: " + ordinepersonalizzato);
		this.loginif = loginif;
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
			PagamentoController pagamentocontroller = new PagamentoController(utente, pagamentoif, ordinepersonalizzato,
					visualizzaordinepersonalizzatoif, loginif, ordine);
			System.out.println("visualizzaordinepersionalizzato: " + ordinepersonalizzato);
			pagamentoif.setVisible(true); // modifica visibilit� interfaccia
		}

	}

}
