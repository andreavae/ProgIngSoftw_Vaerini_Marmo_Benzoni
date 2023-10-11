
package model;

public class Cliente extends User {
	private boolean flagPremium;

	public Cliente(String username, String password) {
		super(username, password);
		this.flagPremium = false;
	}

	public boolean isFlagPremium() {
		return flagPremium;
	}

	public void setFlagPremium(boolean flagPremium) {
		this.flagPremium = flagPremium;
	}

}