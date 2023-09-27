package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.User;
import view.HomeIF;
import view.LoginIF;
import view.SignIF;

public class LoginController {
	private LoginIF loginif; // dichiarazione variabili
	private User user;

	public LoginController(LoginIF loginif, User user) { // costruttore
		this.loginif = loginif;
		this.user = user;

		this.loginif.addLoginListener(new LoginListener()); // apertura interfaccia in caso di successo
		this.loginif.openSignIF(new OpenSignIF());
	}

	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String username = loginif.getUsernameField(); // recuperano il testo inserito dall'utente nei campi di testo
			String password = loginif.getPasswordField();

			user = new User(username, password); // creato un oggetto User
			if (user.isLoginValid()) { // verifica di successo di login
				JOptionPane.showMessageDialog(loginif, "Accesso riuscito!");
				loginif.dispose();
				HomeIF homeif = new HomeIF(username);
				homeif.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(loginif, "Accesso fallito. Riprova, oppure registrati");
			}

		}

	}

	class OpenSignIF implements ActionListener { // transizione tra interfacce

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			SignIF signif = new SignIF(); // creazione oggetto
			SignController signifcontoller = new SignController(signif, null);
			signif.setVisible(true); // interfaccia signif visibile all'utente
			loginif.setVisible(false); // interfaccia login viene nascosta
		}
	}
}
