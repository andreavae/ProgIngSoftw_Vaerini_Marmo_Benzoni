package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Ordine;
import model.OrdinePersonalizzato;
import model.Prodotto;
//import control.OrdinePersonalizzatoController.visualizzaOrdinePersonalizzato;
import model.User;
import view.HomeIF;
import view.LoginIF;
import view.OrdinePersonalizzatoIF;
import view.VisualizzaOrdinePersonalizzatoIF;

public class OrdinePersonalizzatoController {
	private User utente;
	private OrdinePersonalizzatoIF ordinepersonalizzatoif;
	private OrdinePersonalizzato ordinepersonalizzato;
	private HomeIF homeif;
	private LoginIF loginif;
	private Ordine ordine;

	// costruttore
	public OrdinePersonalizzatoController(User utente, OrdinePersonalizzatoIF ordinepersonalizzatoif, HomeIF homeif,
			Ordine ordine, LoginIF loginif) {
		this.utente = utente;
		this.ordine = ordine;
		this.ordinepersonalizzatoif = ordinepersonalizzatoif;
		this.homeif = homeif;
		this.loginif = loginif;
		if (loginif == null) {
			throw new IllegalArgumentException("L'oggetto loginif non può essere null.");
		}
		// this.nPiani = nPiani;
		this.ordinepersonalizzato = new OrdinePersonalizzato(utente, 0, 0);
		System.out.println("ordinepersonalizzatocontroller: " + ordinepersonalizzato);
		// associazione gestori
		this.ordinepersonalizzatoif.back(new back());
		this.ordinepersonalizzatoif.visualizzaOrdine(new VisualizzaOrdinePersonalizzato());
	}

	// gestione bottone back
	public class back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// visibilit� delle interfaccie
			ordinepersonalizzatoif.setVisible(false);
			homeif.setVisible(true);
		}
	}

	// gestione della visualizzazione di un ordine personalizzato
	public class VisualizzaOrdinePersonalizzato implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String dataConsegna = ordinepersonalizzato.dataConsegna(ordinepersonalizzatoif.getDataConsegnaField());
			String occasione = ordinepersonalizzato.occasione(ordinepersonalizzatoif.getOccasioneComboBox());
			String piani = ordinepersonalizzato.pianiStringa(ordinepersonalizzatoif.getPianiComboBox());
			String persone = ordinepersonalizzato.personeStringa(ordinepersonalizzatoif.getnPersoneComboBox());
			Prodotto torta = ordinepersonalizzato.tipoTorta(ordinepersonalizzatoif.getCatalogo());
			double costopiani = ordinepersonalizzato.numerodeipiani(ordinepersonalizzatoif.getPianiComboBox());
			double costopersone = ordinepersonalizzato.numerodipersone(ordinepersonalizzatoif.getnPersoneComboBox());
			double totale = costopiani + costopersone;
			boolean flagVip = loginif.getClientePremiumRadioButton().isSelected();
			if (!flagVip) { // se l'utente non � vip visualizza senza sconto l'ordine

				VisualizzaOrdinePersonalizzatoIF visualizzaordinepersionalizzatoif = new VisualizzaOrdinePersonalizzatoIF(
						utente, dataConsegna, occasione, piani, persone, torta, totale, 0);
				VisualizzaOrdinePersonalizzatoController visualizzaordinepersonalizzatocontroller = new VisualizzaOrdinePersonalizzatoController(
						utente, visualizzaordinepersionalizzatoif, ordinepersonalizzato, loginif, ordine);
				System.out.println("OrdinePersonalizzatoController:" + ordine);

				visualizzaordinepersionalizzatoif.setVisible(true);
			} else { // altrimento ha lo sconto

				VisualizzaOrdinePersonalizzatoIF visualizzaordinepersionalizzatoif = new VisualizzaOrdinePersonalizzatoIF(
						utente, dataConsegna, occasione, piani, persone, torta, totale, 0.3);
				VisualizzaOrdinePersonalizzatoController visualizzaordinepersonalizzatocontroller = new VisualizzaOrdinePersonalizzatoController(
						utente, visualizzaordinepersionalizzatoif, ordinepersonalizzato, loginif, ordine);
				System.out.println("OrdinePersonalizzatoController:" + ordine);
				visualizzaordinepersionalizzatoif.setVisible(true);
			}

		}

	}

}
