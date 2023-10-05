package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("ok");

		}

	}
}
