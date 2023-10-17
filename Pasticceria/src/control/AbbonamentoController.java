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

	public AbbonamentoController(User utente, AbbonamentoIF abbonamentoif, HomeIF homeif) {
		this.utente = utente;
		this.abbonamento = abbonamento;
		this.abbonamentoif = abbonamentoif;
		this.homeif = homeif;

		this.abbonamentoif.DiventaPremium(new abbonati());
	}

	public class abbonati implements ActionListener { // abbonati gestisce gli eventi implememtando l'interfaccia
		// ActionListener
		private String username;
		private String codiceAbbonamento;

		@Override
		public void actionPerformed(ActionEvent e) {
			Abbonamento abbonamento = new Abbonamento(utente);
			codiceAbbonamento = abbonamento.getId();
			System.out.println(codiceAbbonamento);

			boolean flagSignVip = utente.isSignVip(utente.getUsername(), codiceAbbonamento);
			if (flagSignVip) { // si verifica la validit� del pagamento
				System.out.println(flagSignVip);
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
