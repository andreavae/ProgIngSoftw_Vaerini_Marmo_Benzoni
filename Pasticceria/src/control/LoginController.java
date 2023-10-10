package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

//import model.Sconto;
import model.User;
import view.HomeIF;
import view.LoginIF;
import view.SignIF;

public class LoginController {
	private LoginIF loginif; // dichiarazione variabili
	private User user;
	// private Sconto sconto;

	public LoginController(LoginIF loginif, User user) { // costruttore
		this.loginif = loginif;
		this.user = user;

		this.loginif.addLoginListener(new LoginListener()); // apertura interfaccia in caso di successo
		// this.loginif.openSignIF(new OpenSignIF());
	}

	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String username = loginif.getUsernameField(); // recuperano il testo inserito dall'utente nei campi di testo
			String password = loginif.getPasswordField();

			user = new User(username, password); // creato un oggetto User
			if (!loginif.getClientePremiumRadioButton().isSelected()) {
				if (user.isLoginValid()) {
					JOptionPane.showMessageDialog(loginif, "Accesso riuscito!");
					loginif.setVisible(false);
					HomeIF homeif = new HomeIF(user, loginif, 0);
					homeif.setVisible(true);
					HomeController homecontroller = new HomeController(homeif, user, loginif);
				} else {
					JOptionPane.showMessageDialog(loginif, "Accesso fallito. Riprova, oppure registrati");
				}
			} else {
				if (user.isVipLoginValid()) {
					JOptionPane.showMessageDialog(loginif, "Accesso riuscito. Utente riconociuto come cliente Premium");
					loginif.setVisible(false);
					// sconto = new Sconto();
					HomeIF homeif = new HomeIF(user, loginif, 0);
					homeif.setVisible(true);
					HomeController homecontroller = new HomeController(homeif, user, loginif, 0.3);
				} else {
					JOptionPane.showMessageDialog(loginif,
							"Utente non riconociuto come cliente Premium. Entra come cliente oppure paga l'abboanmento.");
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
}
