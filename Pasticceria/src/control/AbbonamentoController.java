package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Abbonamento;
import model.User;
import view.AbbonamentoIF;
import view.HomeIF;
import view.LoginIF;

public class AbbonamentoController {
	private User utente;
	private Abbonamento abbonamento;
	private AbbonamentoIF abbonamentoif;
	private HomeIF homeif;

	public AbbonamentoController(User utente, Abbonamento abbonamento, AbbonamentoIF abbonamentoif, HomeIF homeif) {
		this.utente = utente;
		this.abbonamento = abbonamento;
		this.abbonamentoif = abbonamentoif;
		this.homeif = homeif;

		this.abbonamentoif.DiventaPremium(new abbonati());
	}

	public class abbonati implements ActionListener { // abbonati gestisce gli eventi implememtando l'interfaccia
		// ActionListener
		private String username;
		private int codiceAbbonamento;

		@Override
		public void actionPerformed(ActionEvent e) {
			codiceAbbonamento = abbonamento.getId();
			username = utente.getUsername();
			if (utente.isSignVip(username, codiceAbbonamento)) { // si verifica la validit� del pagamento
				JOptionPane.showMessageDialog(abbonamentoif, "Sei diventato un Cliente Premium");
				abbonamentoif.dispose(); // chiusura interfaccia
				homeif.dispose();
				LoginIF loginif = new LoginIF();
				LoginController logincontroller = new LoginController(loginif, utente);
				loginif.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(abbonamentoif, "Pagamento non avvenuto con successo!");
			}

		}

	}
}
