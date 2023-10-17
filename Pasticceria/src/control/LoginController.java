package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Home;
//import model.Sconto;
import model.User;
import view.HomeIF;
import view.IntroIF;
import view.LoginIF;

public class LoginController {
	private LoginIF loginif; // dichiarazione variabili
	private User user;
	private boolean flagVip;

	public LoginController(LoginIF loginif, User user) { // costruttore
		this.loginif = loginif;
		this.user = user;
		this.flagVip = loginif.getClientePremiumRadioButton().isSelected();
		this.loginif.addLoginListener(new LoginListener()); // apertura interfaccia in caso di successo
		this.loginif.addBackListener(new back());
	}

	public class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String username = loginif.getUsernameField(); // recuperano il testo inserito dall'utente nei campi di testo
			String password = loginif.getPasswordField();

			user = new User(username, password); // creato un oggetto User
			boolean bottonVip = loginif.getClientePremiumRadioButton().isSelected();
			// boolean flagVip = user.isVipUser(username);
			// System.out.println(flagVip);
			if (!bottonVip) { // se l'utente non � vip accede come standard
				if (user.isLoginValid()) {
					JOptionPane.showMessageDialog(loginif, "Accesso riuscito!");
					loginif.setVisible(false);
					HomeIF homeif = new HomeIF(user, loginif, 0);
					Home home = new Home(loginif);
					System.out.println(home.getCliente(user, flagVip).getClass());
					homeif.setVisible(true);
					HomeController homecontroller = new HomeController(homeif, user, loginif);
				} else {
					JOptionPane.showMessageDialog(loginif, "Accesso fallito. Riprova, oppure registrati");
				}
			} else {
				if (flagVip && user.isVipUser(user.getUsername())) { // se l'utente è vip viene confermato oppure mostra
																		// errore
					JOptionPane.showMessageDialog(loginif, "Accesso riuscito. Utente riconociuto come cliente Premium");
					loginif.setVisible(false);
					HomeIF homeif = new HomeIF(user, loginif, 0);
					Home home = new Home(loginif);
					System.out.println(home.getCliente(user, flagVip).getClass());
					homeif.setVisible(true);
					HomeController homecontroller = new HomeController(homeif, user, loginif, 0.3);
				} else {
					JOptionPane.showMessageDialog(loginif,
							"Utente non riconociuto come cliente Premium. Entra come cliente oppure paga l'abboanmento.");
				}
			}
		}
	}

	class back implements ActionListener { // gestione pulsante back

		@Override
		public void actionPerformed(ActionEvent e) {
			IntroIF introif = new IntroIF();
			IntroController introcontroller = new IntroController(introif);
			loginif.dispose();
			introif.setVisible(true);
		}

	}
}
