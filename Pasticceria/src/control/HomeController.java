package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;

import model.Carrello;
import model.User;
import view.HomeIF;
import view.LoginIF;
import view.OrdinePersonalizzatoIF;
import view.OrdineStandardIF;

public class HomeController {
	private HomeIF homeif;
	private User utente;
	private Carrello carrello;
	private double valoreSconto;

	public HomeController(HomeIF homeif, User utente, LoginIF loginif) {
		this.homeif = homeif;
		this.utente = utente;
		carrello = new Carrello();
		this.homeif.openNuovoOrdineIF(new openNuovoOrdineIF());
		this.homeif.openOrdinePersonalizzato(new openOrdinePersonalizzatoIF());
		this.homeif.quit(new Quit());
		this.homeif.openSconto(new sconto());
	}

	class openNuovoOrdineIF implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			OrdineStandardIF ordinestandardif = new OrdineStandardIF(utente);
			OrdineStandardController ordinestandardcontroller = new OrdineStandardController(utente, ordinestandardif,
					carrello, homeif);

			ordinestandardif.setVisible(true);

		}

	}

	class openOrdinePersonalizzatoIF implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			OrdinePersonalizzatoIF ordinepersonalizzatoif = new OrdinePersonalizzatoIF(utente);

			OrdinePersonalizzatoController ordinepersonalizzatocontroller = new OrdinePersonalizzatoController(utente,
					ordinepersonalizzatoif);
			ordinepersonalizzatoif.setVisible(true);

		}

	}

	class Quit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			homeif.dispose();

		}

	}

	class sconto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Random random = new Random();
			int scelta = random.nextInt(3);
			valoreSconto = 0;

			switch (scelta) {
			case 0:
				valoreSconto = 0.15;
				break;
			case 1:
				valoreSconto = 0.30;
				break;
			case 2:
				valoreSconto = 0.50;
				break;
			}
			JOptionPane.showConfirmDialog(homeif, "Sconto Giornaliero del " + valoreSconto * 100 + "%");

		}

		public double getValoreSconto() {
			return valoreSconto;
		}

	}

}
