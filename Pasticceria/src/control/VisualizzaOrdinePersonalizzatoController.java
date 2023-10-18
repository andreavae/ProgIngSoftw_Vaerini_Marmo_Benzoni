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
			LoginIF loginif, Ordine ordine) {

		this.ordine = ordine;
		this.utente = utente;
		this.visualizzaordinepersonalizzatoif = visualizzaordinepersonalizzatoif;
		this.ordine = ordine;
		this.ordinepersonalizzato = ordinepersonalizzato;

		this.loginif = loginif;
		this.visualizzaordinepersonalizzatoif.back(new back());
		this.visualizzaordinepersonalizzatoif.conferma(new conferma());

	}

	// gestione pulsante backg
	public class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			visualizzaordinepersonalizzatoif.setVisible(false); // modifica visibilit� dell'interfaccia

		}

	}

	// gestione pulsante conferma
	public class conferma implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			PagamentoIF pagamentoif = new PagamentoIF(); // interfaccia pagamento
			PagamentoController pagamentocontroller = new PagamentoController(utente, pagamentoif, ordinepersonalizzato,
					visualizzaordinepersonalizzatoif, loginif, ordine);
			System.out.println("visualizzaordinepersionalizzato: " + ordine);

			pagamentoif.setVisible(true); // modifica visibilit� interfaccia
		}

	}

}
