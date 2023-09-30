package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.User;
import view.IntroIF;
import view.LoginIF;
import view.SignIF;

public class IntroController {
	private IntroIF introif;

	public IntroController(IntroIF introif) {
		this.introif = introif;

		this.introif.openLogin(new openLogin());
		this.introif.openSign(new openSign());
	}

	class openLogin implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LoginIF loginif = new LoginIF();
			User loginmodel = new User("", "");
			LoginController logincontroller = new LoginController(loginif, loginmodel);
			introif.dispose();
			loginif.setVisible(true);

		}
	}

	class openSign implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			SignIF signif = new SignIF();
			User loginmodel = new User("", "");
			SignController signifcontoller = new SignController(signif, loginmodel);
			signif.setVisible(true);
			introif.dispose();

		}

	}
}
