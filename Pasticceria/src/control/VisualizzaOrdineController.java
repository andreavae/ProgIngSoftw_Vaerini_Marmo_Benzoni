package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Carrello;
import model.User;
import view.PagamentoIF;
import view.VisualizzaOrdineIF;

public class VisualizzaOrdineController {
	private User utente;
	private VisualizzaOrdineIF visualizzaordineif;

	private Carrello carrello;

	public VisualizzaOrdineController(VisualizzaOrdineIF visualizzaordineif, Carrello carrello) {
		this.visualizzaordineif = visualizzaordineif;
		this.carrello = carrello;
		this.visualizzaordineif.back(new back());
		this.visualizzaordineif.conferma(new conferma());
		this.visualizzaordineif.cancellaOrdine(new cancella());
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
			PagamentoController pagamentocontroller = new PagamentoController(pagamentoif, visualizzaordineif,
					carrello);
			pagamentoif.setVisible(true);
		}

	}

	class cancella implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			visualizzaordineif.dispose();
			carrello.svuotaCarrello();
			carrello = new Carrello(utente, 0);

		}

	}
}
