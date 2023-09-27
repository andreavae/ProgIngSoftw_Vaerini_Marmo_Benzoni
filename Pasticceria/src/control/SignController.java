package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.User;
import view.LoginIF;
import view.SignIF;

public class SignController { // dichiarazione variabili
	private SignIF signif;
	private User user;

	public SignController(SignIF signif, User user) { // costruttore
		this.signif = signif;
		this.user = user;

		this.signif.addResgistratiListener(new RegistratiListener());
	}

	class RegistratiListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String username = signif.getSignUsernameField().getText(); // recuperano il testo inserito dall'utente nei
																		// campi di testo
			String password = signif.getSignPasswordField().getText();
			user = new User(username, password); // creazione oggetto user
			if (user.isSignValid()) { // verifica di successo di registrazione
				JOptionPane.showMessageDialog(signif, "Registrazione riuscita! Effetturare il Login");
				signif.dispose();
				LoginIF loginif = new LoginIF();
				loginif.setVisible(true);
				LoginController controller = new LoginController(loginif, user);
			} else {
				JOptionPane.showMessageDialog(signif, "Registrazione fallita. Riprova!");
			}

		}

	}
}
