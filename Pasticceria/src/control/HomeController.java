package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Abbonamento;
import model.Ordine;
import model.OrdinePersonalizzato;
import model.OrdineStandard;
//import model.Sconto;
import model.User;
import view.AbbonamentoIF;
import view.HomeIF;
import view.LoginIF;
import view.OrdinePersonalizzatoIF;
import view.OrdineStandardIF;

public class HomeController {
	private HomeIF homeif;
	private User utente;
	private OrdineStandard carrello;
	private LoginIF loginif;
	private OrdinePersonalizzato ordinepersonalizzato;
	private OrdinePersonalizzatoIF ordinepersonalizzatoif;

	// costruttore per il cliente standard
	public HomeController(HomeIF homeif, User utente, LoginIF loginif) { // costrutore 1
		this.homeif = homeif;
		this.utente = utente;
		this.loginif = loginif;
		// carrello = new OrdineStandard(utente, 0);
		ordinepersonalizzato = new OrdinePersonalizzato(utente);
		System.out.println("HomeControoler: " + ordinepersonalizzato);
		this.homeif.openNuovoOrdineIF(new openNuovoOrdineIF());
		this.homeif.openOrdinePersonalizzato(new openOrdinePersonalizzatoIF());
		this.homeif.quit(new Quit());
		this.homeif.openAbbonamento(new abbonamento());

	}

	// costruttore per il cliente vip
	public HomeController(HomeIF homeif, User utente, LoginIF loginif, double sconto) { // costruttore 2
		this.homeif = homeif;
		this.utente = utente;
		this.loginif = loginif;
		// carrello = new OrdineStandard(utente, 0.3);
		ordinepersonalizzato = new OrdinePersonalizzato(utente);
		System.out.println("HomeController: " + ordinepersonalizzato);
		this.homeif.openNuovoOrdineIF(new openNuovoOrdineIFVip());
		this.homeif.openOrdinePersonalizzato(new openOrdinePersonalizzatoIFVip());
		this.homeif.openSconto(new sconto(0.3));
		this.homeif.quit(new Quit());

	}

	public class openNuovoOrdineIF implements ActionListener { // gestione apertura interfaccia ordine

		@Override
		public void actionPerformed(ActionEvent e) {
			OrdineStandardIF ordinestandardif = new OrdineStandardIF(utente, 0);
			OrdineStandardController ordinestandardcontroller = new OrdineStandardController(utente, ordinestandardif,
					carrello, homeif, new Ordine(utente), loginif);
			homeif.setVisible(false);
			ordinestandardif.setVisible(true);

		}

	}

	class openNuovoOrdineIFVip implements ActionListener { // gestione nuovo ordine vip

		@Override
		public void actionPerformed(ActionEvent e) {
			OrdineStandardIF ordinestandardif = new OrdineStandardIF(utente, 0.3);
			OrdineStandardController ordinestandardcontroller = new OrdineStandardController(utente, ordinestandardif,
					carrello, homeif, new Ordine(utente), loginif);
			homeif.setVisible(false);
			ordinestandardif.setVisible(true);

		}

	}

	public class openOrdinePersonalizzatoIF implements ActionListener { // gestione apertura interfaccia
																		// personalizzazione

		@Override
		public void actionPerformed(ActionEvent e) {
			OrdinePersonalizzatoIF ordinepersonalizzatoif = new OrdinePersonalizzatoIF(utente, 0);
			OrdinePersonalizzato op = new OrdinePersonalizzato(utente);
			OrdinePersonalizzatoController ordinepersonalizzatocontroller = new OrdinePersonalizzatoController(utente,
					ordinepersonalizzatoif, homeif, op, loginif);
			homeif.setVisible(false);
			ordinepersonalizzatoif.setVisible(true);

		}

	}

	class openOrdinePersonalizzatoIFVip implements ActionListener { // gestion personalizza vip

		@Override
		public void actionPerformed(ActionEvent e) {
			OrdinePersonalizzatoIF ordinepersonalizzatoif = new OrdinePersonalizzatoIF(utente, 0.3);
			ordinepersonalizzato = new OrdinePersonalizzato(utente);
			OrdinePersonalizzatoController ordinepersonalizzatocontroller = new OrdinePersonalizzatoController(utente,
					ordinepersonalizzatoif, homeif, ordinepersonalizzato, loginif);
			homeif.setVisible(false);

			ordinepersonalizzatoif.setVisible(true);

		}

	}

	class Quit implements ActionListener { // gestione uscita dal programma

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}

	class sconto implements ActionListener { // gestione sconto
		private double valoreSconto;

		public sconto(double valoreSconto) {
			this.valoreSconto = valoreSconto;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// sconto = new Sconto();
			valoreSconto = 0.3;
			JOptionPane.showMessageDialog(homeif, "Sconto Giornaliero del " + valoreSconto * 100 + "%");
			HomeIF homeifvip = new HomeIF(utente, new LoginIF(), valoreSconto);
			homeifvip.setVisible(true);
			HomeController homecontrollervip = new HomeController(homeifvip, utente, loginif, 0.3);
			// System.out.println(sconto.getSconto());
		}

		public double getValoreSconto(double valoreSconto) {
			System.out.println(0.3);
			return valoreSconto;
		}

	}

	class abbonamento implements ActionListener { // gestione apertura abbonamento

		@Override
		public void actionPerformed(ActionEvent e) {
			Abbonamento abbonamento = new Abbonamento(utente);
			AbbonamentoIF abbonamentoif = new AbbonamentoIF();
			AbbonamentoController abbonamentocontroller = new AbbonamentoController(utente, abbonamento, abbonamentoif,
					homeif);
			abbonamentoif.setVisible(true);
		}

	}
}
