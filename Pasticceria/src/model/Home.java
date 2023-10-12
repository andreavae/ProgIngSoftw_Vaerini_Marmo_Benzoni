package model;

import view.LoginIF;

public class Home {
	private LoginIF loginif;

	public Home(LoginIF loginif) {
		this.loginif = loginif;
	}

	public User getCliente(User utente, boolean flag) {
		if (flag == true) {
			utente = new ClientePremium(utente.getUsername(), utente.getPassword());
			return utente;
		} else {
			utente = new Cliente(utente.getUsername(), utente.getPassword());
			return utente;
		}
	}
}
