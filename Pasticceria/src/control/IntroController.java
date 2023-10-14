package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.User;
import view.IntroIF;
import view.LoginIF;
import view.SignIF;

public class IntroController { // interfaccia iniziale
	private IntroIF introif;
	public Object openLogin;
	public boolean buttonClick;

	public IntroController(IntroIF introif) {
		this.introif = introif;
		this.buttonClick = false;
		this.introif.openLogin(new openLogin()); // associazione gestore eventi
		this.introif.openSign(new openSign());
	}

	class openLogin implements ActionListener { // apertura innterfaccia per il login

		@Override
		public void actionPerformed(ActionEvent e) {
			buttonClick = true;
			LoginIF loginif = new LoginIF();
			User loginmodel = new User("", "");
			LoginController logincontroller = new LoginController(loginif, loginmodel);
			introif.dispose();
			loginif.setVisible(true);

		}
	}

	class openSign implements ActionListener { // apertura per interfaccia sign

		@Override
		public void actionPerformed(ActionEvent e) {
			SignIF signif = new SignIF();
			User loginmodel = new User("", "");
			SignController signifcontoller = new SignController(signif, loginmodel);
			signif.setVisible(true);
			introif.dispose();

		}

	}

	public boolean isButtonClick() {
		return buttonClick;
	}

}
