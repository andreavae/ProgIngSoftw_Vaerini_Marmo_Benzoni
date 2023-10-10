package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.OrdinePersonalizzato;
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

	// costruttore
	public OrdinePersonalizzatoController(User utente, OrdinePersonalizzatoIF ordinepersonalizzatoif, HomeIF homeif,
			OrdinePersonalizzato ordinepersonalizzato, LoginIF loginif) {
		this.utente = utente;
		this.ordinepersonalizzatoif = ordinepersonalizzatoif;
		this.homeif = homeif;
		this.loginif = loginif;
		if (loginif == null) {
			throw new IllegalArgumentException("L'oggetto loginif non può essere null.");
		}
		// this.nPiani = nPiani;
		this.ordinepersonalizzato = new OrdinePersonalizzato(utente, 0);
		System.out.println("ordinepersonalizzatocontroller: " + ordinepersonalizzato);
		// associazione gestori
		this.ordinepersonalizzatoif.back(new back());
		this.ordinepersonalizzatoif.visualizzaOrdine(new VisualizzaOrdinePersonalizzato());
	}

	// gestione bottone back
	class back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// visibilit� delle interfaccie
			ordinepersonalizzatoif.setVisible(false);
			homeif.setVisible(true);
		}
	}

	// gestione della visualizzazione di un ordine personalizzato
	class VisualizzaOrdinePersonalizzato implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String dataConsegna = ordinepersonalizzato.dataConsegna(ordinepersonalizzatoif.getDataConsegnaField());
			String occasione = ordinepersonalizzato.occasione(ordinepersonalizzatoif.getOccasioneComboBox());
			String piani = ordinepersonalizzato.pianiStringa(ordinepersonalizzatoif.getPianiComboBox());
			String persone = ordinepersonalizzato.personeStringa(ordinepersonalizzatoif.getnPersoneComboBox());
			double costopiani = ordinepersonalizzato.numerodeipiani(ordinepersonalizzatoif.getPianiComboBox());
			double costopersone = ordinepersonalizzato.numerodipersone(ordinepersonalizzatoif.getnPersoneComboBox());
			double totale = costopiani + costopersone;
			boolean flagVip = loginif.getClientePremiumRadioButton().isSelected();
			// Ordine op = new OrdinePersonalizzato(utente, totale);
			if (!flagVip) {
				VisualizzaOrdinePersonalizzatoIF visualizzaordinepersionalizzatoif = new VisualizzaOrdinePersonalizzatoIF(
						utente, dataConsegna, occasione, piani, persone, totale, 0);
				VisualizzaOrdinePersonalizzatoController visualizzaordinepersonalizzatocontroller = new VisualizzaOrdinePersonalizzatoController(
						utente, visualizzaordinepersionalizzatoif, ordinepersonalizzato, loginif);
				visualizzaordinepersionalizzatoif.setVisible(true);
			} else {
				VisualizzaOrdinePersonalizzatoIF visualizzaordinepersionalizzatoif = new VisualizzaOrdinePersonalizzatoIF(
						utente, dataConsegna, occasione, piani, persone, totale, 0.3);
				VisualizzaOrdinePersonalizzatoController visualizzaordinepersonalizzatocontroller = new VisualizzaOrdinePersonalizzatoController(
						utente, visualizzaordinepersionalizzatoif, ordinepersonalizzato, loginif);
				visualizzaordinepersionalizzatoif.setVisible(true);
			}

		}

	}
}
