
package model;

public class Cliente extends User {
	private boolean flagPremium;

	public Cliente(String username, String password) { // costruttore
		super(username, password);
		this.flagPremium = false;
	}

	public boolean isFlagPremium() { // verifica del premium
		return flagPremium;
	}

	public void setFlagPremium(boolean flagPremium) { // impostazione del premium
		this.flagPremium = flagPremium;
	}

}