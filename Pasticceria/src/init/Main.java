package init;

import java.awt.EventQueue;

import control.LoginController;
import model.User;
import view.LoginIF;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LoginIF loginif = new LoginIF();
					User loginmodel = new User("", "");
					LoginController logincontroller = new LoginController(loginif, loginmodel);
					loginif.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
