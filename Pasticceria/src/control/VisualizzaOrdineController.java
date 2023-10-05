package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Ordine;
import model.OrdineStandard;
import model.TipoOrdine;
import model.User;
import view.PagamentoIF;
import view.VisualizzaOrdineIF;

public class VisualizzaOrdineController {
	private User utente;
	private VisualizzaOrdineIF visualizzaordineif;

	private OrdineStandard carrello;

	public VisualizzaOrdineController(User utente, VisualizzaOrdineIF visualizzaordineif, OrdineStandard carrello) {
		this.utente = utente;
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
			Ordine ordine;
			PagamentoIF pagamentoif = new PagamentoIF();
			PagamentoController pagamentocontroller = new PagamentoController(pagamentoif, visualizzaordineif,
					carrello);
			if (utente.isVipUser(utente.getUsername())) {
				ordine = new Ordine(utente, carrello.getTotale(0.3));
			} else {
				ordine = new Ordine(utente, carrello.getTotale(0));
			}
			System.out.println(ordine.getCodiceOrdine());
			System.out.println(ordine.getUsernameUtente());
			TipoOrdine tipoordine = TipoOrdine.STANDARD;
			System.out.println(tipoordine);
			System.out.println(ordine.getPrezzoOrdine());
			pagamentoif.setVisible(true);
		}

	}

	class cancella implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			visualizzaordineif.dispose();
			carrello.svuotaCarrello();
			carrello = new OrdineStandard(utente, 0);

		}

	}
}
