
package model;

public class ClientePremium extends User {
	private boolean flagPremium;

	public ClientePremium(String username, String password) {
		super(username, password);
		this.flagPremium = true;
	}

	public boolean isFlagPremium() {
		return flagPremium;
	}

	public void setFlagPremium(boolean flagPremium) {
		this.flagPremium = flagPremium;
	}

}