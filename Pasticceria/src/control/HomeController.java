package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Abbonamento;
import model.Ordine;
import model.OrdinePersonalizzato;
import model.OrdineStandard;
import model.Sconto;
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
	private Sconto sconto;
	private LoginIF loginif;
	private OrdinePersonalizzato ordinepersonalizzato;

	public HomeController(HomeIF homeif, User utente, LoginIF loginif) {
		this.homeif = homeif;
		this.utente = utente;
		this.loginif = loginif;
		carrello = new OrdineStandard(utente, 0);
		this.homeif.openNuovoOrdineIF(new openNuovoOrdineIF());
		this.homeif.openOrdinePersonalizzato(new openOrdinePersonalizzatoIF());
		this.homeif.quit(new Quit());
		this.homeif.openAbbonamento(new abbonamento());
		// this.homeif.openSconto(new sconto());
	}

	public HomeController(HomeIF homeif, User utente, LoginIF loginif, Sconto sconto) {
		this.homeif = homeif;
		this.utente = utente;
		this.sconto = sconto;
		carrello = new OrdineStandard(utente, sconto.getSconto());
		this.homeif.openNuovoOrdineIF(new openNuovoOrdineIFVip());
		this.homeif.openOrdinePersonalizzato(new openOrdinePersonalizzatoIFVip());
		this.homeif.openSconto(new sconto(sconto.getSconto()));
		this.homeif.quit(new Quit());

	}

	class openNuovoOrdineIF implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			OrdineStandardIF ordinestandardif = new OrdineStandardIF(utente, 0);
			OrdineStandardController ordinestandardcontroller = new OrdineStandardController(utente, ordinestandardif,
					carrello, homeif, new Ordine(utente, 0));
			homeif.setVisible(false);
			ordinestandardif.setVisible(true);

		}

	}

	class openNuovoOrdineIFVip implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			OrdineStandardIF ordinestandardif = new OrdineStandardIF(utente, sconto.getSconto());
			OrdineStandardController ordinestandardcontroller = new OrdineStandardController(utente, ordinestandardif,
					carrello, homeif, new Ordine(utente, sconto.getSconto()));
			homeif.setVisible(false);
			ordinestandardif.setVisible(true);

		}

	}

	class openOrdinePersonalizzatoIF implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			OrdinePersonalizzatoIF ordinepersonalizzatoif = new OrdinePersonalizzatoIF(utente, 0);

			OrdinePersonalizzatoController ordinepersonalizzatocontroller = new OrdinePersonalizzatoController(utente,
					ordinepersonalizzatoif, homeif, ordinepersonalizzatoif.getDataConsegnaField(),
					ordinepersonalizzatoif.getOccasioneComboBox(), ordinepersonalizzatoif.getnPersoneComboBox(),
					ordinepersonalizzatoif.getPianiComboBox(), ordinepersonalizzato);
			homeif.setVisible(false);
			ordinepersonalizzatoif.setVisible(true);

		}

	}

	class openOrdinePersonalizzatoIFVip implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			OrdinePersonalizzatoIF ordinepersonalizzatoif = new OrdinePersonalizzatoIF(utente, 0.3);

			OrdinePersonalizzatoController ordinepersonalizzatocontroller = new OrdinePersonalizzatoController(utente,
					ordinepersonalizzatoif, homeif, ordinepersonalizzatoif.getDataConsegnaField(),
					ordinepersonalizzatoif.getOccasioneComboBox(), ordinepersonalizzatoif.getnPersoneComboBox(),
					ordinepersonalizzatoif.getPianiComboBox(), ordinepersonalizzato);
			homeif.setVisible(false);
			ordinepersonalizzatoif.setVisible(true);

		}

	}

	class Quit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}

	class sconto implements ActionListener {
		private double valoreSconto;
		private Sconto sconto;

		public sconto(double valoreSconto) {
			this.valoreSconto = valoreSconto;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			sconto = new Sconto();
			valoreSconto = sconto.getSconto();
			JOptionPane.showMessageDialog(homeif, "Sconto Giornaliero del " + valoreSconto * 100 + "%");
			HomeIF homeifvip = new HomeIF(utente, new LoginIF(), valoreSconto);
			homeifvip.setVisible(true);
			HomeController homecontrollervip = new HomeController(homeifvip, utente, loginif, sconto);
			// System.out.println(sconto.getSconto());
		}

		public double getValoreSconto(double valoreSconto) {
			System.out.println(sconto.getSconto());
			return valoreSconto;
		}

	}

	class abbonamento implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Abbonamento abbonamento = new Abbonamento(utente);
			AbbonamentoIF abbonamentoif = new AbbonamentoIF();
			AbbonamentoController abbonamentocontroller = new AbbonamentoController(utente, abbonamento, abbonamentoif);
			abbonamentoif.setVisible(true);
		}

	}
}
