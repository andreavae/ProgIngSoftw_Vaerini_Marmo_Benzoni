package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.User;
import view.HomeIF;
import view.LoginIF;

public class LoginController {
	private LoginIF loginif;
	private User user;

	public LoginController(LoginIF loginif, User user) {
		this.loginif = loginif;
		this.user = user;

		this.loginif.addLoginListener(new LoginListener());
	}

	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String username = loginif.getUsernameField();
			String password = loginif.getPasswordField();

			user = new User(username, password);
			if (user.isLoginValid()) {
				JOptionPane.showMessageDialog(loginif, "Accesso riuscito!");
				loginif.dispose();
				HomeIF homeif = new HomeIF(username);
				homeif.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(loginif, "Accesso fallito. Riprova, oppure registrati");
			}

		}

	}

}
