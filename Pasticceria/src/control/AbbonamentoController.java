package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Abbonamento;
import model.User;
import view.AbbonamentoIF;

public class AbbonamentoController {
	private User utente;
	private Abbonamento abbonamento;
	private AbbonamentoIF abbonamentoif;

	public AbbonamentoController(User utente, Abbonamento abbonamento, AbbonamentoIF abbonamentoif) {
		this.utente = utente;
		this.abbonamento = abbonamento;
		this.abbonamentoif = abbonamentoif;

		this.abbonamentoif.DiventaPremium(new abbonati());
	}

	class abbonati implements ActionListener {
		private String username;
		private int codiceAbbonamento;

		@Override
		public void actionPerformed(ActionEvent e) {
			codiceAbbonamento = abbonamento.getId();
			username = utente.getUsername();
			if (utente.isSignVip(username, codiceAbbonamento)) {
				JOptionPane.showMessageDialog(abbonamentoif, "Sei diventato un Cliente Premium");
			} else {
				JOptionPane.showMessageDialog(abbonamentoif, "Pagamento non avvenuto con successo!");
			}

		}

	}
}
