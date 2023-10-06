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
	private Ordine ordine;
	private OrdineStandard carrello;
	private TipoOrdine tipoOrdine;

	public VisualizzaOrdineController(User utente, VisualizzaOrdineIF visualizzaordineif, OrdineStandard carrello,
			Ordine ordine) {
		this.ordine = ordine;
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

			PagamentoIF pagamentoif = new PagamentoIF();
			PagamentoController pagamentocontroller = new PagamentoController(utente, pagamentoif, visualizzaordineif,
					carrello, ordine);
			if (utente.isVipUser(utente.getUsername())) {
				ordine = new Ordine(utente);

			} else {
				ordine = new Ordine(utente);

			}
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
