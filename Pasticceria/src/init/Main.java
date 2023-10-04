package init;

import java.awt.EventQueue;

import control.IntroController;
import view.IntroIF;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // avvio dell'interfaccia utente
			@Override
			public void run() {
				try {
					IntroIF introif = new IntroIF(); // avvio view IntroIF
					IntroController introcontroller = new IntroController(introif);
					introif.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
