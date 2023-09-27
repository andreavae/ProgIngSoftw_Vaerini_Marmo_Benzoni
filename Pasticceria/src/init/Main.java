package init;

import java.awt.EventQueue;

import control.LoginController;
import model.User;
import view.LoginIF;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // avvio dell'interfaccia utente
			@Override
			public void run() {
				try {
					LoginIF loginif = new LoginIF();
					User loginmodel = new User("", "");
					LoginController logincontroller = new LoginController(loginif, loginmodel); // gestione della logica
																								// interfaccia
					loginif.setVisible(true); // visibilità interfaccia login
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
