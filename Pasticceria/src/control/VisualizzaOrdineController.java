package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Ordine;
import model.OrdineStandard;
import model.User;
import view.LoginIF;
import view.PagamentoIF;
import view.VisualizzaOrdineIF;

public class VisualizzaOrdineController {
	private User utente;
	private VisualizzaOrdineIF visualizzaordineif;
	private Ordine ordine;
	private OrdineStandard carrello;
	private LoginIF loginif;

	// costruttore
	public VisualizzaOrdineController(User utente, VisualizzaOrdineIF visualizzaordineif, OrdineStandard carrello,
			Ordine ordine, LoginIF loginif) {
		this.ordine = ordine;
		this.utente = utente;
		this.loginif = loginif;
		this.visualizzaordineif = visualizzaordineif;
		this.carrello = carrello;
		this.visualizzaordineif.back(new back());
		this.visualizzaordineif.conferma(new conferma());
		this.visualizzaordineif.cancellaOrdine(new cancella());
	}

	// gestione pulsante back
	public class back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			visualizzaordineif.setVisible(false); // modifica visualizzazione interfaccia
		}

	}

	// gestione pulsante conferma
	public class conferma implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			PagamentoIF pagamentoif = new PagamentoIF();
			PagamentoController pagamentocontroller = new PagamentoController(utente, pagamentoif, visualizzaordineif,
					carrello, ordine, loginif); // oggetto per la gestione del pagamento
			System.out.println("VisualizzaOrdineContoller:" + ordine);
			pagamentoif.setVisible(true); // modifica visibilit� interfaccia
		}
	}

	// gestione pulsante cancella
	class cancella implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			visualizzaordineif.dispose();
			carrello.svuotaCarrello();
			carrello = new OrdineStandard(utente, 0);

		}

	}
}
