package model;

import view.LoginIF;

public class Home {
	private LoginIF loginif;

	public Home(LoginIF loginif) { // costruttore
		this.loginif = loginif;
	}

	public User getCliente(User utente, boolean flag) { // ritorna cliente premium se true altrimenti standard
		if (flag == true) {
			utente = new ClientePremium(utente.getUsername(), utente.getPassword());
			return utente;
		} else {
			utente = new Cliente(utente.getUsername(), utente.getPassword());
			return utente;
		}
	}
}
